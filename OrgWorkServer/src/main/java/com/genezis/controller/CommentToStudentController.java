package com.genezis.controller;

import com.genezis.dao.CommentToStudentDAO;
import com.genezis.model.CommentToStudent;
import com.genezis.service.CommentToStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommentToStudentController {
    @Autowired
    private CommentToStudentService commentToStudentService;

    @RequestMapping(value = "/commentToStudent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentToStudent> getCommentToStudent(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        CommentToStudent commentToStudent = commentToStudentService.getCommentToStudent(id);
        if (commentToStudent == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<CommentToStudent>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CommentToStudent>(commentToStudent, HttpStatus.OK);
    }
}
