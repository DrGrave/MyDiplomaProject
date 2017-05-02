package com.genezis.service;

import com.genezis.dao.TimeteableDAO;
import com.genezis.model.Timeteable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
@Service("timeteableService")
@Transactional
public class TimeteableServiceImpl implements TimeteableService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private TimeteableDAO timeteableDAO = context.getBean(TimeteableDAO.class);
    @Override
    public void saveTimeteable(Timeteable timeteable) {
        timeteableDAO.saveTimeteable(timeteable);
    }

    @Override
    public Timeteable getTimeteable(int id) {
        return timeteableDAO.getTimeteable(id);
    }

    @Override
    public Timeteable editTimeteable(Timeteable timeteable) {
        return timeteableDAO.editTimeteable(timeteable);
    }

    @Override
    public void deleteTimeteable(Timeteable timeteable) {
        timeteableDAO.deleteTimeteable(timeteable);
    }

    @Override
    public Timeteable ifExists(Timeteable timeteable) {
        return timeteableDAO.ifExistsTimeteable(timeteable);
    }


    @Override
    public Timeteable getTimeteableByProfessor(int id) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        Time time = new Time(24);
        time.setTime(date.getTime());
        return timeteableDAO.getTimeteableByProfessorIdTime(id, time, date);
    }
}
