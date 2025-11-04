package orc.mapper;


import orc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper


public interface UserMapper {
    // 通过 @Select 注解编写 SQL，查询 employee_id 为 users 的记录，并映射到 User 实体类
    @Select("SELECT * FROM user WHERE Useraccount = #{usercount}")
    User findUserById(String usercount);
}

