package com.genezis.dao;

import com.genezis.model.Queue;
import com.genezis.model.Work;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface QueueDAO {
    void saveQueue(Queue queue);
    List<Queue> listQueue();
    Queue getQueue(int id);
    Queue editQueue(Queue queue);
    void deleteQuee(Queue queue);
    Queue ifExistsQueue(Queue queue);
    List<Queue> listQueueProfessorById(int id);
    List<Work> listOfWorksToStudent(int id, int prof);
}
