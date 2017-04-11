package com.genezis.service;

import com.genezis.dao.*;
import com.genezis.model.StudentGroup;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private GroupDAO groupDAO = context.getBean(GroupDAO.class);


    @Override
    public void saveStudentGroup(StudentGroup studentGroup) {
        groupDAO.saveGroup(studentGroup);
    }

    @Override
    public StudentGroup getStudentGroup(int id) {
        return groupDAO.getGroupById(id);
    }

    @Override
    public StudentGroup editStudentGroup(StudentGroup studentGroup) {
        return groupDAO.editGroup(studentGroup);
    }

    @Override
    public void deleteStudentGroup(StudentGroup studentGroup) {
        groupDAO.deleteGroup(studentGroup);
    }

    @Override
    public StudentGroup ifExists(StudentGroup studentGroup) {
        return groupDAO.ifExistsStudentGroup(studentGroup);
    }
}
