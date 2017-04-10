package com.genezis.service;

import com.genezis.model.Timeteable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("timeteableService")
@Transactional
public class TimeteableServiceImpl implements TimeteableService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @Override
    public void saveTimeteable(Timeteable timeteable) {

    }

    @Override
    public Timeteable getTimeteable(int id) {
        return null;
    }

    @Override
    public Timeteable editTimeteable(Timeteable timeteable) {
        return null;
    }

    @Override
    public void deleteTimeteable(Timeteable timeteable) {

    }

    @Override
    public Timeteable ifExists(Timeteable timeteable) {
        return null;
    }
}
