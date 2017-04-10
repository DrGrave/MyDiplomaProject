package com.genezis.service;

import com.genezis.model.CommentToWork;

/**
 * Created by vadim on 03.04.17.
 */
public interface CommentToWorkService {
    void saveCommentToWork(CommentToWork commentToWork);
    CommentToWork getCommentToWork(int id);
    CommentToWork editCommentToWork(CommentToWork commentToWork);
    void deleteCommentToWork(CommentToWork commentToWork);
    CommentToWork ifExists(CommentToWork commentToWork);
}
