package orc.service.impl;

import orc.entity.User;
import orc.mapper.CreateMapper;
import orc.service.UsercreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsercreateServiceImpl implements UsercreateService {
@Autowired
CreateMapper createMapper;
    @Override
    public String Normaluser(User user) {
        try {
            // 新增：获取插入影响行数
            int insertRows = createMapper.insertUser(user);
            // 只有影响行数>0时才返回成功
            return insertRows > 0 ? "success" : "fail";
        } catch (Exception e) {
            // 捕获主键冲突、唯一约束冲突等数据库异常
            return "fail";
        }
    }
    @Override
    public User Adminuser(User user) {
        return null;
    }
}
