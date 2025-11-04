package orc.mapper;

import orc.entity.Submission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubmissionMapper {

    @Insert("INSERT INTO submission (SubmissionId, Userid, Questionid, code, language, status) " +
            "VALUES (#{submissionId}, #{userId}, #{questionId}, #{code}, #{language}, #{status})")
    int insertSubmission(Submission submission);
}
