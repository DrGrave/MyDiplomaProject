package com.genezis.service;

import com.genezis.model.M2MProfessorSubject;
import com.genezis.model.Subject;

import java.util.List;

/**
 * Created by vadim on 13.04.17.
 */
public interface M2MProfessorSubjectService {
    List<Subject> getListSubjectToProfessor(int id);
}
