package orc.service;

import orc.entity.GETDTO.Selectmessage;
import orc.entity.Question_message;

import java.util.List;

public interface QuestionSelectService {
    // 注意：参数名建议与实现类保持一致，便于理解
    List<Question_message> selectMessage(Selectmessage selectmessage);
}
