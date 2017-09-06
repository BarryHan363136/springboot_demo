package com.iris.study.springboot.mapper.shiro;

import com.iris.study.springboot.base.BaseMapper;
import com.iris.study.springboot.entity.shiro.UserRole;
import org.springframework.stereotype.Repository;

@Repository("userRoleMapper")
public interface UserRoleMapper extends BaseMapper<UserRole, Integer> {

}