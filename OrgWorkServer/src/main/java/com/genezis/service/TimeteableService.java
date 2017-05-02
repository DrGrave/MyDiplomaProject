package com.genezis.service;

import com.genezis.model.Timeteable;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface TimeteableService {
    void saveTimeteable(Timeteable timeteable);
    Timeteable getTimeteable(int id);
    Timeteable editTimeteable(Timeteable timeteable);
    void deleteTimeteable(Timeteable timeteable);
    Timeteable ifExists(Timeteable timeteable);
    Timeteable getTimeteableByProfessor(int id);

}
