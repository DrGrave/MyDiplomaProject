package com.genezis.service;

import com.genezis.model.*;

import java.util.List;

/**
 * Created by vadim on 20.04.17.
 */
public interface M2MGroupTimetableService {
    M2MGroupTimeteable getGroupTimetable(int id);
    List<Timeteable> getListTimeteablesToStudents(int id);
    List<MyUser> getListProfessors(int id);
    List<Subject> getListSubjectToProfessor(int idGroup, int idProfessor);

    List<Subject> getListSubjectToStudent(int idGroup);
}
