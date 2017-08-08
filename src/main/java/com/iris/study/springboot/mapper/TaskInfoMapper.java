package com.iris.study.springboot.mapper;

import com.iris.study.springboot.base.BaseMapper;
import com.iris.study.springboot.entity.TaskInfo;
import org.springframework.stereotype.Repository;

@Repository("taskInfoMapper")
public interface TaskInfoMapper extends BaseMapper<TaskInfo, Integer> {



}
