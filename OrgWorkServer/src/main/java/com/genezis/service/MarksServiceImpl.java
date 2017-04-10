package com.genezis.service;

import com.genezis.model.Marks;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("marksService")
@Transactional
public class MarksServiceImpl implements MarksService{
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @Override
    public void saveMarks(Marks marks) {

    }

    @Override
    public Marks getMarks(int id) {
        return null;
    }

    @Override
    public Marks editMarks(Marks marks) {
        return null;
    }

    @Override
    public void deleteMarks(Marks marks) {

    }

    @Override
    public Marks ifExists(Marks marks) {
        return null;
    }
}
