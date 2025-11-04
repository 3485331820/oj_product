package orc.mapper;

import orc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CreateMapper {
    @Insert("INSERT INTO user (Userid, Useraccount, Userpassword) " +
            "VALUES (#{Userid}, #{Useraccount}, #{Userpassword})")
    int insertUser(User user);
}