package orc.entity;

import lombok.Data;


import java.util.Date;


@Data
public class User {
    // 用户id
    private Integer Userid;
    // 用户账号
    private String Useraccount;
    // 用户角色，默认0
    private Integer Userrole = 0;
    // 用户关联对象id
    private Integer User_object;
    // 用户密码
    private String Userpassword;
    // 创建时间，默认当前时间戳
    private Date Createtime = new Date();
    // 更新时间，默认当前时间戳
    private Date Updatetime = new Date();
    // 是否删除，默认0
    private Integer Isdelete = 0;
    public Integer getUserid() {
        return Userid;
    }

    public void setUserid(Integer userid) {
        Userid = userid;
    }

    // Useraccount 的 getter 和 setter
    public String getUseraccount() {
        return Useraccount;
    }

    public void setUseraccount(String useraccount) {
        Useraccount = useraccount;
    }

    // Userrole 的 getter 和 setter
    public Integer getUserrole() {
        return Userrole;
    }

    public void setUserrole(Integer userrole) {
        Userrole = userrole;
    }

    // User_object 的 getter 和 setter
    public Integer getUser_object() {
        return User_object;
    }

    public void setUser_object(Integer user_object) {
        User_object = user_object;
    }

    // Userpassword 的 getter 和 setter
    public String getUserpassword() {
        return Userpassword;
    }

    public void setUserpassword(String userpassword) {
        Userpassword = userpassword;
    }

    // Createtime 的 getter 和 setter
    public Date getCreatetime() {
        return Createtime;
    }

    public void setCreatetime(Date createtime) {
        Createtime = createtime;
    }

    // Updatetime 的 getter 和 setter
    public Date getUpdatetime() {
        return Updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        Updatetime = updatetime;
    }

    // Isdelete 的 getter 和 setter
    public Integer getIsdelete() {
        return Isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        Isdelete = isdelete;
    }

}