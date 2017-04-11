package com.genezis.service;

import com.genezis.dao.*;
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

    private CommentToStudentDAO commentToStudentDAO = context.getBean(CommentToStudentDAO.class);



    @Override
    public void saveCommentToStudent(CommentToStudent commentToStudent) {
        commentToStudentDAO.saveCommentToStudent(commentToStudent);
    }

    @Override
    public CommentToStudent getCommentToStudent(int id) {
        return commentToStudentDAO.getCommentToStudentById(id);
    }

    @Override
    public CommentToStudent editCommentToStudent(CommentToStudent commentToStudent) {
        return commentToStudentDAO.editCommentToStudent(commentToStudent);
    }

    @Override
    public void deleteCommentToStudent(CommentToStudent commentToStudent) {
        commentToStudentDAO.deleteCommentToStudent(commentToStudent);
    }

    @Override
    public CommentToStudent ifExists(CommentToStudent commentToStudent) {
        return commentToStudentDAO.ifExistsCommentToSudent(commentToStudent);
    }
}
