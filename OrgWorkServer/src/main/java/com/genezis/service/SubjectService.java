package com.genezis.service;

import com.genezis.model.Subject;

/**
 * Created by vadim on 03.04.17.
 */
public interface SubjectService {
    void saveSubject(Subject subject);
    Subject getSubject(int id);
    Subject editSubject(Subject subject);
    void deleteSubject(Subject subject);
    Subject ifExists(Subject subject);
}
