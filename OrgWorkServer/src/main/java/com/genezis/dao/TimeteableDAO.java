package com.genezis.dao;

import com.genezis.model.Timeteable;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface TimeteableDAO {
    void saveTimeteable(Timeteable timeteable);
    List<Timeteable> listTimeteable();
    Timeteable getTimeteable(int id);
    Timeteable editTimeteable(Timeteable timeteable);
    void deleteTimeteable(Timeteable timeteable);
    Timeteable ifExistsTimeteable(Timeteable timeteable);
    Timeteable getTimeteableByProfessorIdTime(int id, Time time, Date date);
}
