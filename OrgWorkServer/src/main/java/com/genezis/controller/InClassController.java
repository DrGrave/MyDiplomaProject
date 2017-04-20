package com.genezis.controller;

import com.genezis.dao.InClassDAO;
import com.genezis.model.InClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


/**
 * Created by vadim on 03.04.17.
 */
@RestController
public class InClassController {
    @Autowired
    private
    InClassDAO inClassDAO;

    @RequestMapping(value = "/inClass/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InClass> getUserType(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        InClass inClass = inClassDAO.getInClass(id);
        if (inClass == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<InClass>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<InClass>(inClass, HttpStatus.OK);
    }
}
