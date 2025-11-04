package orc.service.impl;


import orc.entity.GETDTO.CodeSubmissionDTO;
import orc.entity.POSTDTO.ResponseResult;
import orc.entity.Submission;
import orc.mapper.SubmissionMapper;
import orc.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionMapper submissionMapper;

    @Override
    public ResponseResult<String> submitCode(CodeSubmissionDTO submissionDTO) {
        try {
            // 生成随机主键SubmissionId（6位随机数示例）
            Random random = new Random();
            int min = 100000;
            int max = 999999;
            int submissionId = random.nextInt(max - min + 1) + min;

            // 转换DTO为实体类
            Submission submission = new Submission();
            submission.setSubmissionId(submissionId);
            submission.setUserId(submissionDTO.getUserId());
            submission.setQuestionId(submissionDTO.getQuestionId());
            submission.setCode(submissionDTO.getCode());
            submission.setLanguage(submissionDTO.getLanguage());
            // 状态默认是Pending，无需额外设置

            // 插入数据库
            int rows = submissionMapper.insertSubmission(submission);
            if (rows > 0) {
                return new ResponseResult<>(200, "代码提交成功", "提交ID: " + submissionId);
            } else {
                return new ResponseResult<>(500, "代码提交失败", null);
            }
        } catch (Exception e) {
            return new ResponseResult<>(500, "提交过程异常: " + e.getMessage(), null);
        }
    }
}
