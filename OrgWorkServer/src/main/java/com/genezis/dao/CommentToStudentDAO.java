package com.genezis.dao;

import com.genezis.model.CommentToStudent;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface CommentToStudentDAO {
    void saveCommentToStudent(CommentToStudent commentToStudent);
    List<CommentToStudent> listCommentToStudent();
    CommentToStudent getCommentToStudentById(int id);
    CommentToStudent editCommentToStudent(CommentToStudent commentToStudent);
    void deleteCommentToStudent(CommentToStudent commentToStudent);
}
