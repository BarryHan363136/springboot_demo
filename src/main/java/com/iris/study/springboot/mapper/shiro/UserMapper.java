package com.iris.study.springboot.mapper.shiro;

import com.iris.study.springboot.base.BaseMapper;
import com.iris.study.springboot.entity.shiro.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper extends BaseMapper<UserInfo, Integer> {

    @Select("select *from t_user where account=#{account}")
    UserInfo findByAccount(String account);

}