package com.genezis.dao;

import com.genezis.model.Work;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface WorkDAO {
    public void saveWork(Work work);
    public List<Work> listWork();
    public Work getWork(int id);
    public Work editWork(Work work);
    void deleteWork(Work work);
}
