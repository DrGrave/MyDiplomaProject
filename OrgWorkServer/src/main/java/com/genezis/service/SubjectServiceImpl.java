package com.genezis.service;

import com.genezis.model.Subject;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @Override
    public void saveSubject(Subject subject) {

    }

    @Override
    public Subject getSubject(int id) {
        return null;
    }

    @Override
    public Subject editSubject(Subject subject) {
        return null;
    }

    @Override
    public void deleteSubject(Subject subject) {

    }

    @Override
    public Subject ifExists(Subject subject) {
        return null;
    }
}
