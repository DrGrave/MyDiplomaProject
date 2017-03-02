package com.sethomecompany.dao;

import com.sethomecompany.domain.Subject;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public interface SubjectDAO {
    List<Subject> getAllSubject();

    List<Subject> getAllSubjectByProfessorId(Integer id);

    Subject getSubjectById(Integer subjectId);


    Integer addSubject(Subject subject);

    void updateSubject(Subject subject);

    void deleteSubject(Subject subject);

    void deleteSubjectById(Integer id);
}
