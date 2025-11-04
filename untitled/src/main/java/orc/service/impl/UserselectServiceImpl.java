package orc.service.impl;

import orc.entity.User;
import orc.mapper.UserMapper;
import orc.service.UerselectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserselectServiceImpl implements UerselectService {
    @Autowired
    private UserMapper userMapper;
    public User SelectById(String id) {
        return userMapper.findUserById(id);
    }
}
