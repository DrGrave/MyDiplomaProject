package com.genezis.service;

import com.genezis.model.CommentToStudent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("commentToStudentService")
@Transactional
public class CommentToStudentServiceImpl implements CommentToStudentService{
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @Override
    public void saveCommentToStudent(CommentToStudent commentToStudent) {

    }

    @Override
    public CommentToStudent getCommentToStudent(int id) {
        return null;
    }

    @Override
    public CommentToStudent editCommentToStudent(CommentToStudent commentToStudent) {
        return null;
    }

    @Override
    public void deleteCommentToStudent(CommentToStudent commentToStudent) {

    }

    @Override
    public CommentToStudent ifExists(CommentToStudent commentToStudent) {
        return null;
    }
}
