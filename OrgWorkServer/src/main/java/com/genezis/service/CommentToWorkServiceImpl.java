package com.genezis.service;

import com.genezis.dao.*;
import com.genezis.model.CommentToWork;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
@Service("commentToWorkService")
@Transactional
public class CommentToWorkServiceImpl implements CommentToWorkService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private CommentToWorkDAO commentToWorkDAO = context.getBean(CommentToWorkDAO.class);

    @Override
    public void saveCommentToWork(CommentToWork commentToWork) {
        commentToWorkDAO.saveCommentToWork(commentToWork);
    }

    @Override
    public CommentToWork getCommentToWork(int id) {
        return commentToWorkDAO.getCommentToWorkById(id);
    }

    @Override
    public CommentToWork editCommentToWork(CommentToWork commentToWork) {
        return commentToWorkDAO.editCommentToWork(commentToWork);
    }

    @Override
    public void deleteCommentToWork(CommentToWork commentToWork) {
        commentToWorkDAO.deleteCommentToWork(commentToWork);
    }

    @Override
    public CommentToWork ifExists(CommentToWork commentToWork) {
        return commentToWorkDAO.ifExistsCommentToWork(commentToWork);
    }

    @Override
    public List<CommentToWork> listOfCommentsToUserWorks(int idUSer, int idWork) {
        return commentToWorkDAO.getListForUserByWork(idWork, idUSer);
    }
}
