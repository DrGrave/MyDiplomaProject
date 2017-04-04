package com.genezis.dao;

import com.genezis.model.Timeteable;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface TimeteableDAO {
    public void saveTimeteable(Timeteable timeteable);
    public List<Timeteable> listTimeteable();
    public Timeteable getTimeteable(int id);
    public Timeteable editTimeteable(Timeteable timeteable);
    void deleteTimeteable(Timeteable timeteable);
}
