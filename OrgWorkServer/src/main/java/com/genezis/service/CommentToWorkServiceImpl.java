package com.genezis.service;

import com.genezis.model.CommentToWork;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("commentToWorkService")
@Transactional
public class CommentToWorkServiceImpl implements CommentToWorkService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @Override
    public void saveCommentToWork(CommentToWork commentToWork) {

    }

    @Override
    public CommentToWork getCommentToWork(int id) {
        return null;
    }

    @Override
    public CommentToWork editCommentToWork(CommentToWork commentToWork) {
        return null;
    }

    @Override
    public void deleteCommentToWork(CommentToWork commentToWork) {

    }

    @Override
    public CommentToWork ifExists(CommentToWork commentToWork) {
        return null;
    }
}
