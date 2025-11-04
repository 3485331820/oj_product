package orc.controller;

import orc.entity.GETDTO.CodeSubmissionDTO;
import orc.entity.POSTDTO.ResponseResult;
import orc.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PostMapping("/codeSubmission")
    public ResponseEntity<ResponseResult<String>> codeSubmission(@RequestBody CodeSubmissionDTO submissionDTO) {
        System.out.println("接收数据："+submissionDTO);
        ResponseResult<String> result = submissionService.submitCode(submissionDTO);
        return ResponseEntity.ok(result);
    }
}