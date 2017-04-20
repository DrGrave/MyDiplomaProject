package com.genezis.service;

import com.genezis.dao.M2MGroupTimeteableDAO;
import com.genezis.model.M2MGroupTimeteable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 20.04.17.
 */
@Service("groupTimetable")
@Transactional
public class M2MGroupTimetableServiceImpl implements M2MGroupTimetableService{

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private M2MGroupTimeteableDAO m2MGroupTimeteableDAO = context.getBean(M2MGroupTimeteableDAO.class);
    @Override
    public M2MGroupTimeteable getGroupTimetable(int id) {
        return m2MGroupTimeteableDAO.getM2MGroupTimeteable(id);
    }
}
