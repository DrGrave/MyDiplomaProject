package com.genezis.service;


import com.genezis.model.Work;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface WorkService {
    void saveWork(Work work);
    Work editWork(Work work);
    void deleteWork(Work work);
    Work ifExistsWork(Work work);
    Work getWorkById(int id);
    List<Work> getWorksByProfessorSubject(int idProfessor, int idWork);
}
