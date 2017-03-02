package com.sethomecompany.dao;

import com.sethomecompany.domain.Queue;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public interface QueueDAO {
    List<Queue> getAllQueue();

    List<Queue> getAllStudentsByProfessorId(Integer id);

    Queue getQueueById(Integer queueId);


    Integer addQueue(Queue queue);

    void updateQueue(Queue queue);

    void deleteQueue(Queue queue);

    void deleteQueueById(Integer id);
}
