package com.genezis.service;

import com.genezis.model.Queue;
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

    @Override
    public void saveQueue(Queue queue) {

    }

    @Override
    public Queue getQueue(int id) {
        return null;
    }

    @Override
    public Queue editQueue(Queue queue) {
        return null;
    }

    @Override
    public void deleteQueue(Queue queue) {

    }

    @Override
    public Queue ifExists(Queue queue) {
        return null;
    }
}
