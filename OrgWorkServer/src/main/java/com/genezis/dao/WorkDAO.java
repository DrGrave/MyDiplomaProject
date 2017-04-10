package com.genezis.dao;

import com.genezis.model.Work;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface WorkDAO {
    void saveWork(Work work);
    List<Work> listWork();
    Work getWork(int id);
    Work editWork(Work work);
    void deleteWork(Work work);
    Work ifExistsWork(Work work);
}
