package com.iris.study.springboot.service.shiro.impl;

import java.util.List;

import com.iris.study.springboot.entity.shiro.ModuleInfo;
import com.iris.study.springboot.mapper.shiro.ModuleMapper;
import com.iris.study.springboot.service.shiro.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleMapper moduleMapper;

    /**
     * 获取角色模块
     * @param userId
     * @return
     */
    public List<ModuleInfo> findModuleByUserId(int userId) {
        return moduleMapper.findModuleByUserId(userId);
    }
}