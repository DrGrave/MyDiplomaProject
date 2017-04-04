package com.genezis.dao;

import com.genezis.model.CommentToStudent;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface CommentToStudentDAO {
    public void saveCommentToStudent(CommentToStudent commentToStudent);
    public List<CommentToStudent> listCommentToStudent();
    public CommentToStudent getCommentToStudentById(int id);
    public CommentToStudent editCommentToStudent(CommentToStudent commentToStudent);
    public void deleteCommentToStudent(CommentToStudent commentToStudent);
}
