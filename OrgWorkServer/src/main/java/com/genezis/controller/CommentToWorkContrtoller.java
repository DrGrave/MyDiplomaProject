package com.genezis.controller;

import com.genezis.dao.CommentToWorkDAO;
import com.genezis.model.CommentToWork;
import com.genezis.service.CommentToWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommentToWorkContrtoller {
    @Autowired
    private CommentToWorkService commentToWorkService;

    @RequestMapping(value = "/commentToWork/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentToWork> getCommentToWork(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        CommentToWork commentToWork = commentToWorkService.getCommentToWork(id);
        if (commentToWork == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<CommentToWork>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CommentToWork>(commentToWork, HttpStatus.OK);
    }
}
