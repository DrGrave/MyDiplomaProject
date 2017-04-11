package com.genezis.service;

import com.genezis.dao.SubjectDAO;
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
    private SubjectDAO subjectDAO = context.getBean(SubjectDAO.class);
    @Override
    public void saveSubject(Subject subject) {
        subjectDAO.saveSubject(subject);
    }

    @Override
    public Subject getSubject(int id) {
        return subjectDAO.getSubject(id);
    }

    @Override
    public Subject editSubject(Subject subject) {
        return subjectDAO.editSubject(subject);
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectDAO.deleteSubject(subject);
    }

    @Override
    public Subject ifExists(Subject subject) {
        return subjectDAO.ifExistsSubject(subject);
    }
}
