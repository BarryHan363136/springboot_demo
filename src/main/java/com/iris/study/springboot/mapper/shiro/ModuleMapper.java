package com.iris.study.springboot.mapper.shiro;

import com.iris.study.springboot.base.BaseMapper;
import com.iris.study.springboot.entity.shiro.Module;
import org.springframework.stereotype.Repository;

@Repository("moduleMapper")
public interface ModuleMapper extends BaseMapper<Module, Integer> {

}