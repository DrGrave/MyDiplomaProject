package com.genezis.dao;

import com.genezis.model.CommentToWork;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface CommentToWorkDAO {
    void saveCommentToWork(CommentToWork commentToWork);
    List<CommentToWork> listCommentToWork();
    CommentToWork getCommentToWorkById(int id);
    CommentToWork editCommentToWork(CommentToWork commentToWork);
    void deleteCommentToWork(CommentToWork commentToWork);
}
