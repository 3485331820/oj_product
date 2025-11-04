package orc.service.impl;

import orc.entity.GETDTO.Selectmessage;
import orc.entity.Qsqselct;
import orc.entity.Question_message;
import orc.mapper.QuestionMapper;
import orc.service.QuestionSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionSelectServiceImpl implements QuestionSelectService {
    @Autowired
    QuestionMapper questionMapper;

    @Override
    public List<Question_message> selectMessage(Selectmessage selectmessage) {
        // 1. 将前端字符串难度转换为数据库对应的数字
        Integer level = convertDifficulty(selectmessage.getDifficulty());
        if (level == null) {
            // 处理无效难度值（如返回空列表）
            return new ArrayList<>();
        }

        // 2. 封装转换后的参数（使用Qsqselct，其Level为Integer类型，匹配数据库字段）
        Qsqselct queryParam = new Qsqselct();
        queryParam.setLevel(level); // 设置转换后的数字难度
        queryParam.setTitle(selectmessage.getLanguage()); // 题目类型（原language参数）

        System.out.println("查询参数"+queryParam.getTitle());
        System.out.println("查询参数"+queryParam.getLevel());
        return questionMapper.selectQuestions(queryParam);
    }

    private Integer convertDifficulty(String difficultyStr) {
        if (difficultyStr == null) {
            return null;
        }
        switch (difficultyStr) {
            case "简单":
                return 1;
            case "普通": // 若前端是“中等”，这里改为"中等"即可
                return 2;
            case "困难":
                return 3;
            default:
                return null; // 无效值
        }
    }
}