package com.genezis.service;

import com.genezis.model.ListSubjectsToProfessor;
import com.genezis.model.M2MGroupTimeteable;
import com.genezis.model.Timeteable;

import java.util.List;

/**
 * Created by vadim on 20.04.17.
 */
public interface M2MGroupTimetableService {
    M2MGroupTimeteable getGroupTimetable(int id);
    List<Timeteable> getListTimeteablesToStudents(int id);
    List<ListSubjectsToProfessor> getListSubjectToProfessor(int id);
}
