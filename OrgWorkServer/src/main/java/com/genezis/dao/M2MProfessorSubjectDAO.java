package com.genezis.dao;

import com.genezis.model.M2MProfessorSubject;

import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
public interface M2MProfessorSubjectDAO {
    void saveM2MProfessorSubject(M2MProfessorSubject m2mProfessorSubject);
    List<M2MProfessorSubject> listM2MProfessorSubject();
    M2MProfessorSubject getM2MProfessorSubject(int id);
    M2MProfessorSubject editM2MProfessorSubject(M2MProfessorSubject m2mProfessorSubject);
    void deleteM2MProfessorSubject(M2MProfessorSubject m2mProfessorSubject);
}
