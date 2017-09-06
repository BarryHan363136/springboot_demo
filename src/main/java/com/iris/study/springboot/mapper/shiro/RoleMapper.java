package com.iris.study.springboot.mapper.shiro;

import com.iris.study.springboot.base.BaseMapper;
import com.iris.study.springboot.entity.shiro.Role;
import org.springframework.stereotype.Repository;

@Repository("roleMapper")
public interface RoleMapper extends BaseMapper<Role, Integer> {

}