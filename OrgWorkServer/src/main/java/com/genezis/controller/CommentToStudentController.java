package com.genezis.controller;

import com.genezis.dao.CommentToStudentDAO;
import com.genezis.model.CommentToStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by vadim on 03.04.17.
 */
@RestController
public class CommentToStudentController {
    @Autowired
    private CommentToStudentDAO commentToStudentDAO;

    @RequestMapping(value = "/commentToStudent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentToStudent> getUserType(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        CommentToStudent commentToStudent = commentToStudentDAO.getCommentToStudentById(id);
        if (commentToStudent == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<CommentToStudent>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CommentToStudent>(commentToStudent, HttpStatus.OK);
    }
}
