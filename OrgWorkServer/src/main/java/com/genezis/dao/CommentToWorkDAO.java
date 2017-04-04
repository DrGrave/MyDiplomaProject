package com.genezis.dao;

import com.genezis.model.CommentToWork;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface CommentToWorkDAO {
    public void saveCommentToWork(CommentToWork commentToWork);
    public List<CommentToWork> listCommentToWork();
    public CommentToWork getCommentToWorkById(int id);
    public CommentToWork editCommentToWork(CommentToWork commentToWork);
    public void deleteCommentToWork(CommentToWork commentToWork);
}
