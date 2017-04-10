package com.genezis.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("queueService")
@Transactional
public class QueueServiceImpl implements QueueService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
}
