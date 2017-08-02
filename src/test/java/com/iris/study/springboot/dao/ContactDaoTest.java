package com.iris.study.springboot.dao;

import com.iris.study.springboot.base.BaseTest;
import com.iris.study.springboot.entity.Contact;
import com.iris.study.springboot.mapper.ContactMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactDaoTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(ContactDaoTest.class);

    @Autowired
    private ContactMapper contactMapper;

    @Test
    public void testSelectAll(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "张三13");
        List<Contact> list = contactMapper.findResults(map);
        for (Contact contact : list){
            logger.info("=======================>"+contact.getName());
        }
    }

}
