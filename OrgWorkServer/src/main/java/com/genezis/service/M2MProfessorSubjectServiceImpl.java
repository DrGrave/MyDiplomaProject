package com.genezis.service;

import com.genezis.dao.M2MProfessorSubjectDAO;
import com.genezis.model.M2MProfessorSubject;
import com.genezis.model.Subject;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vadim on 13.04.17.
 */
@Service(value = "m2MProfessorSubjectService")
@Transactional
public class M2MProfessorSubjectServiceImpl implements M2MProfessorSubjectService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    M2MProfessorSubjectDAO m2mProfessorSubjectDAO = context.getBean(M2MProfessorSubjectDAO.class);
    @Override
    public List<Subject> getListSubjectToProfessor(int id) {
        List<M2MProfessorSubject> m2MProfessorSubjectList = m2mProfessorSubjectDAO.getListSubjectsToProfessor(id);
        List<Subject> subjectList = new ArrayList<>();
        if (!m2MProfessorSubjectList.isEmpty()){
        for (M2MProfessorSubject m2MProfessorSubject : m2MProfessorSubjectList){
            subjectList.add(m2MProfessorSubject.getIdSubject());
        }
        return subjectList;
        }else return null;
    }
}
