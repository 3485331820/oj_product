package orc.controller;

import orc.entity.GETDTO.Selectmessage;
import orc.entity.Question_message;
import orc.service.impl.QuestionSelectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class CategoriesController {
    @Autowired
    private QuestionSelectServiceImpl questionSelectServiceImpl;

    // 正确用法：@RequestBody 修饰方法参数，用于接收前端传递的JSON数据
    @PostMapping("/categories")
    public ResponseEntity<List<Question_message>> getCategories(@RequestBody Selectmessage mess) {
         System.out.println("前端参数"+mess);
         List<Question_message> messages=questionSelectServiceImpl.selectMessage(mess);
         System.out.println("查询结果"+messages);
        return ResponseEntity.ok(messages);
    }
}