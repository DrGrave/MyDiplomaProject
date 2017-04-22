package com.genezis.service;

import com.genezis.model.Queue;
import com.genezis.model.Work;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface QueueService {
    void saveQueue(Queue queue);
    Queue getQueue(int id);
    Queue editQueue(Queue queue);
    void deleteQueue(Queue queue);
    Queue ifExists(Queue queue);
    List<Queue> getListToProfessorById(int id);
    List<Work> listWorksToStudentById(int id, int profid);
    Queue getListToProfessorByIdWorkStudent(int id, int idWork, int idStudent);
}
