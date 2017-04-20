package com.genezis.controller;

import com.genezis.dao.AttorneyDAO;
import com.genezis.model.Attorney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AttorneyController {
    @Autowired
    private AttorneyDAO attorneyDAO;

    @RequestMapping(value = "/attorney/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Attorney> getUserType(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Attorney attorney = attorneyDAO.getAttorneyById(id);
        if (attorney == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Attorney>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Attorney>(attorney, HttpStatus.OK);
    }
}
