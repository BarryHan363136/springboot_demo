package com.iris.study.springboot.mapper.base;

import com.iris.study.springboot.entity.business.Contact;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DemoMapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex",  column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    List<Contact> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    Contact getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(Contact user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(Contact user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}
