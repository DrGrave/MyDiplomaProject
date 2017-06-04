package com.genezis.service;

import com.genezis.dao.MarksDAO;
import com.genezis.model.Marks;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
@Service("marksService")
@Transactional
public class MarksServiceImpl implements MarksService{
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private MarksDAO marksDAO = context.getBean(MarksDAO.class);
    @Override
    public void saveMarks(Marks marks) {
        marksDAO.saveMarks(marks);
    }

    @Override
    public Marks getMarks(int id) {
        return marksDAO.getMarks(id);
    }

    @Override
    public Marks editMarks(Marks marks) {
        return marksDAO.editMarks(marks);
    }

    @Override
    public void deleteMarks(Marks marks) {
        marksDAO.deleteMarks(marks);
    }

    @Override
    public List<Marks> getListMarks(int idUser, int idSubject) {
        return marksDAO.getListMarks(idUser, idSubject);
    }

    @Override
    public Marks ifExists(Marks marks) {
        return marksDAO.ifExistsMarks(marks);
    }
}
