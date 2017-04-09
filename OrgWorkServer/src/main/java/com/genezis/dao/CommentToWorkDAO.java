package com.genezis.dao;

import com.genezis.model.CommentToWork;

import java.util.List;


public interface CommentToWorkDAO {
    void saveCommentToWork(CommentToWork commentToWork);
    List<CommentToWork> listCommentToWork();
    CommentToWork getCommentToWorkById(int id);
    CommentToWork editCommentToWork(CommentToWork commentToWork);
    void deleteCommentToWork(CommentToWork commentToWork);
}
