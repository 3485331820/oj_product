package orc.docker;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import orc.entity.JAVA_DOCKER.ExecuteCodeResponse;
import orc.entity.JAVA_DOCKER.ExecuteCodeRequest;
import orc.entity.JAVA_DOCKER.ExecuteMessage;
import orc.entity.JAVA_DOCKER.JudgeInfo;


import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class JavaCodeSandboxTemplate implements CodeSandBox
{
    private static final String GLOBAL_CODE_DIR_NAME = "tmpCode";

    private static final String GLOBAL_JAVA_CLASS_NAME = "Main.java";

    private static final long TIME_OUT = 5000L;
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest codeRequest) { // 修正方法名
        String code = codeRequest.getCode();
        // 把用户的代码保存为文件
        File CodeDir = Savecode(code);
        //编译代码，得到 class 文件
        ExecuteMessage compileFileExecuteMessage = ssagecompileFile(CodeDir);
        System.out.println(compileFileExecuteMessage);
        //执行代码，得到输出结果
        List<ExecuteMessage> executeMessageList = runFile(CodeDir, codeRequest.getInputList());
//       收集整理输出结果
        ExecuteCodeResponse outputResponse = getOutputResponse(executeMessageList);
        return outputResponse;
    }


    public File Savecode(String code)
    {
        String userDir = System.getProperty("user.dir");
        String codeDir = userDir + File.separator + GLOBAL_CODE_DIR_NAME;
        if (!FileUtil.exist(codeDir)) {
            FileUtil.mkdir(codeDir);
        }
        String UserCodeDir = codeDir + File.separator + UUID.randomUUID();
        String CodeDir = UserCodeDir + File.separator + GLOBAL_JAVA_CLASS_NAME;
        File UserCodeDirFile = FileUtil.writeString(code,CodeDir, StandardCharsets.UTF_8);
        return UserCodeDirFile;
    }
    public ExecuteMessage ssagecompileFile(File userCodeFile) {
        String compileCmd = String.format("javac -encoding utf-8 %s", userCodeFile.getAbsolutePath());
        try {
            Process compileProcess = Runtime.getRuntime().exec(compileCmd);
            ExecuteMessage executeMessage = ProcessUtils.runProcessAndGetMessage(compileProcess, "编译");
            if (executeMessage.getExitValue() != 0) {
                throw new RuntimeException("编译错误");
            }
            return executeMessage;
        } catch (Exception e) {
//            return getErrorResponse(e);
            throw new RuntimeException(e);
        }
    }
    public List<ExecuteMessage> runFile(File userCodeFile, List<String> inputList) {
        String userCodeParentPath = userCodeFile.getParentFile().getAbsolutePath();

        List<ExecuteMessage> executeMessageList = new ArrayList<>();
        for (String inputArgs : inputList) {
            String runCmd = String.format("java -Xmx256m -Dfile.encoding=UTF-8 -cp %s Main %s", userCodeParentPath, inputArgs);
            try {
                Process runProcess = Runtime.getRuntime().exec(runCmd);
                // 超时控制
                new Thread(() -> {
                    try {
                        Thread.sleep(TIME_OUT);
                        System.out.println("超时了，中断");
                        runProcess.destroy();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
                ExecuteMessage executeMessage = ProcessUtils.runProcessAndGetMessage(runProcess, "运行");
                System.out.println(executeMessage);
                executeMessageList.add(executeMessage);
            } catch (Exception e) {
                throw new RuntimeException("执行错误", e);
            }
        }
        return executeMessageList;
    }
    public ExecuteCodeResponse getOutputResponse(List<ExecuteMessage> executeMessageList) {
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        List<String> outputList = new ArrayList<>();
        // 取用时最大值，便于判断是否超时
        long maxTime = 0;
        for (ExecuteMessage executeMessage : executeMessageList) {
            String errorMessage = executeMessage.getErrorMessage();
            if (StrUtil.isNotBlank(errorMessage)) {
                executeCodeResponse.setMessage(errorMessage);
                // 用户提交的代码执行中存在错误
                executeCodeResponse.setStatus(3);
                break;
            }
            outputList.add(executeMessage.getMessage());
            Long time = executeMessage.getTime();
            if (time != null) {
                maxTime = Math.max(maxTime, time);
            }
        }
        // 正常运行完成
        if (outputList.size() == executeMessageList.size()) {
            executeCodeResponse.setStatus(1);
        }
        executeCodeResponse.setOutputList(outputList);
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setTime(maxTime);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
