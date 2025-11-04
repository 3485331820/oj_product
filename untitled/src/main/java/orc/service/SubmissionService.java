package orc.service;


import orc.entity.GETDTO.CodeSubmissionDTO;
import orc.entity.POSTDTO.ResponseResult;

public interface SubmissionService {
    ResponseResult<String> submitCode(CodeSubmissionDTO submissionDTO);
}
