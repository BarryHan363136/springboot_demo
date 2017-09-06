package com.iris.study.springboot.service.shiro;

import com.iris.study.springboot.entity.shiro.ModuleInfo;

import java.util.List;


public interface ModuleService {
    /**
     * 获取角色模块
     * @param userId
     * @return
     */
    List<ModuleInfo> findModuleByUserId(int userId);
}