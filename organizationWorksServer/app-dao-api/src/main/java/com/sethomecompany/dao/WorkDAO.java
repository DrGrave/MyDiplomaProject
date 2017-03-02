package com.sethomecompany.dao;

import com.sethomecompany.domain.Work;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public interface WorkDAO {
    List<Work> getAllWork();

    List<Work> getAllWorkBySubjectId(Integer id);

    Work getWorkById(Integer workId);


    Integer addWork(Work work);

    void updateWork(Work work);

    void deleteWork(Work work);

    void deleteWorkById(Integer id);
}
