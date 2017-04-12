package com.genezis.service;

import com.genezis.model.CommentToWork;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface CommentToWorkService {
    void saveCommentToWork(CommentToWork commentToWork);
    CommentToWork getCommentToWork(int id);
    CommentToWork editCommentToWork(CommentToWork commentToWork);
    void deleteCommentToWork(CommentToWork commentToWork);
    CommentToWork ifExists(CommentToWork commentToWork);
    List<CommentToWork> listOfCommentsToUserWorks(int idUSer, int idWork);
}
