package com.iris.study.springboot.mapper.shiro;

import com.iris.study.springboot.base.BaseMapper;
import com.iris.study.springboot.entity.shiro.RoleModule;
import org.springframework.stereotype.Repository;

@Repository("roleModuleMapper")
public interface RoleModuleMapper extends BaseMapper<RoleModule, Integer> {

}