package com.genezis.service;

import com.genezis.dao.M2MStudentWorkDAO;
import com.genezis.model.M2MStudentWork;
import com.genezis.model.Subject;
import com.genezis.model.Work;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Vadim on 12.04.2017.
 */
@Service(value = "m2MStudentWorkService")
@Transactional
public class M2MStudentWorkServiceImpl implements M2MStudentWorkService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    M2MStudentWorkDAO m2MStudentWorkDAO = context.getBean(M2MStudentWorkDAO.class);

    @Override
    public List<Subject> getListSubjects(int idUser) {
        return m2MStudentWorkDAO.getListSubjectsToWorksStudent(idUser);
    }

    @Override
    public List<Work> getListWorks(int id, int idUser) {
        return m2MStudentWorkDAO.getListOfWorksToStudent(id, idUser);
    }

    @Override
    public M2MStudentWork getM2MStudentWork(int id, int idUser) {
        return m2MStudentWorkDAO.getM2MStudentWorkInfo(id, idUser);
    }
}
