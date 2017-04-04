package com.genezis.dao;

import com.genezis.model.Subject;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface SubjectDAO {
    public void saveSubject(Subject subject);
    public List<Subject> listSubject();
    public Subject getSubject(int id);
    public Subject editSubject(Subject subject);
}
