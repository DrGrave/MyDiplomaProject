package com.genezis.service;

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

    @Override
    public void saveStudentGroup(StudentGroup studentGroup) {

    }

    @Override
    public StudentGroup getStudentGroup(int id) {
        return null;
    }

    @Override
    public StudentGroup editStudentGroup(StudentGroup studentGroup) {
        return null;
    }

    @Override
    public void deleteStudentGroup(StudentGroup studentGroup) {

    }

    @Override
    public StudentGroup ifExists(StudentGroup studentGroup) {
        return null;
    }
}
