package com.genezis.service;

import com.genezis.model.CommentToStudent;

/**
 * Created by vadim on 03.04.17.
 */
public interface CommentToStudentService {
    void saveCommentToStudent(CommentToStudent commentToStudent);
    CommentToStudent getCommentToStudent(int id);
    CommentToStudent editCommentToStudent(CommentToStudent commentToStudent);
    void deleteCommentToStudent(CommentToStudent commentToStudent);
    CommentToStudent ifExists(CommentToStudent commentToStudent);
}
