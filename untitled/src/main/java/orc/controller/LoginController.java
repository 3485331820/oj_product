package orc.controller;

import orc.entity.POSTDTO.ResponseResult;
import orc.entity.User;

import orc.exception.BusinessException;
import orc.service.impl.UsercreateServiceImpl;
import orc.service.impl.UserselectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserselectServiceImpl userselectService;

    @PostMapping("/Password-login")
    public ResponseEntity<ResponseResult<User>> loginByPassword(@RequestBody User user) {
        // 1. 验证账号是否为空
        String userAccount = user.getUseraccount();
        String userPassword = user.getUserpassword();

        if (userAccount == null || userAccount.trim().isEmpty()) {
            throw new BusinessException(400, "账号不能为空");
        }

        // 2. 查询用户信息
        User dbUser = userselectService.SelectById(userAccount);
        System.out.println(dbUser);

        // 3. 验证用户是否存在及密码是否正确
        if (dbUser == null) {
            throw new BusinessException(401, "账号不存在");
        }

        if (!dbUser.getUserpassword().equals(userPassword)) {
            throw new BusinessException(401, "密码不正确");
        }

        // 4. 登录成功
        ResponseResult<User> response = new ResponseResult<>(200, "登录成功", dbUser);
        return ResponseEntity.ok(response);
    }

    @Autowired
    private UsercreateServiceImpl usercreateService;

    @PostMapping("/create")
    public ResponseEntity<ResponseResult<User>> createUser(@RequestBody User user) {
        System.out.println("接收到 /login/create 请求，参数：" + user);

        // 验证账号密码不为空
        if (user.getUseraccount() == null || user.getUseraccount().trim().isEmpty()
                || user.getUserpassword() == null || user.getUserpassword().trim().isEmpty()) {
            throw new BusinessException(400, "账号或密码不能为空");
        }

        // 检查账号是否已存在
        User dbUser = userselectService.SelectById(user.getUseraccount());
        if (dbUser != null) {
            throw new BusinessException(409, "账户已存在");
        }

        // 生成随机用户ID
        Random random = new Random();
        int max = 999999;
        int min = 100000;
        int randomUserId = random.nextInt(max - min + 1) + min;
        user.setUserid(randomUserId);

        // 创建用户
        String status = usercreateService.Normaluser(user);
        if (!"success".equals(status)) {
            throw new BusinessException(500, "用户创建失败");
        }

        ResponseResult<User> result = new ResponseResult<>(200, "成功创建", user);
        return ResponseEntity.ok(result);
    }
}
