package com.genezis.controller;

import com.genezis.dao.GroupDAO;
import com.genezis.model.StudentGroup;
import com.genezis.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentGroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentGroup> getUserType(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        StudentGroup studentGroup = groupService.getStudentGroup(id);
        if (studentGroup == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<StudentGroup>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StudentGroup>(studentGroup, HttpStatus.OK);
    }
}
