package com.genezis.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vadim on 03.04.17.
 */
public class TimeteableServiceImpl implements TimeteableService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
}
