package com.iris.study.springboot.mapper.business;

import com.iris.study.springboot.base.BaseMapper;
import com.iris.study.springboot.entity.business.Contact;
import org.springframework.stereotype.Repository;

@Repository("contactMapper")
public interface ContactMapper extends BaseMapper<Contact, Integer> {

}