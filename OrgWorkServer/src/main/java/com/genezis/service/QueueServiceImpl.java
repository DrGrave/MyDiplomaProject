package com.genezis.service;

import com.genezis.dao.QueueDAO;
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
    private QueueDAO queueDAO = context.getBean(QueueDAO.class);
    @Override
    public void saveQueue(Queue queue) {
        queueDAO.saveQueue(queue);
    }

    @Override
    public Queue getQueue(int id) {
        return queueDAO.getQueue(id);
    }

    @Override
    public Queue editQueue(Queue queue) {
        return queueDAO.editQueue(queue);
    }

    @Override
    public void deleteQueue(Queue queue) {
        queueDAO.deleteQuee(queue);
    }

    @Override
    public Queue ifExists(Queue queue) {
        return queueDAO.ifExistsQueue(queue);
    }
}
