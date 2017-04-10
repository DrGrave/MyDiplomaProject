package com.genezis.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("commentToStudentService")
@Transactional
public class CommentToStudentServiceImpl implements CommentToStudentService{
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
}
