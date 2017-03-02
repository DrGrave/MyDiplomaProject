package com.sethomecompany.dao;

import com.sethomecompany.domain.Timeteable;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public interface TimeteableDAO {
    List<Timeteable> getAllTimeteable();

    List<Timeteable> getAllTimeteableByProfessorId(Integer id);

    Timeteable getTimeteableById(Integer timeteableId);


    Integer addTimeteable(Timeteable timeteable);

    void updateTimeteable(Timeteable timeteable);

    void deleteTimeteable(Timeteable timeteable);

    void deleteTimeteableById(Integer id);
}
