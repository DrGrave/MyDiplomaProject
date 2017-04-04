package com.genezis.dao;

import com.genezis.model.Queue;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface QueueDAO {
    public void saveQueue(Queue queue);
    public List<Queue> listQueue();
    public Queue getQueue(int id);
    public Queue editQueue(Queue queue);
    void deleteQuee(Queue queue);
}
