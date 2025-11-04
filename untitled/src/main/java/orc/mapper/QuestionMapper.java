package orc.mapper;

import orc.entity.Qsqselct;
import orc.entity.Question_message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    /**
     * 根据转换后的数字难度和题目类型查询
     */
    @Select("SELECT QuestionId, Level, Content, Answer, Title, Object " +
            "FROM question " +
            "WHERE Isdelete = 0 " +
            "AND Level = #{level} " +  // 匹配Qsqselct的Integer类型Level
            "AND Title = #{title}")   // 匹配Qsqselct的Title（题目类型）
    List<Question_message> selectQuestions(Qsqselct queryParam);
}