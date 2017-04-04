package com.genezis.dao;

import com.genezis.model.Subject;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface SubjectDAO {
    void saveSubject(Subject subject);
    List<Subject> listSubject();
    Subject getSubject(int id);
    Subject editSubject(Subject subject);
    void deleteSubject(Subject subject);
}
