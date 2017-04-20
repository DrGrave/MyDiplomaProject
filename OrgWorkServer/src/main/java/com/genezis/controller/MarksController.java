package com.genezis.controller;
import com.genezis.model.Marks;
import com.genezis.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MarksController {
    @Autowired
    private MarksService marksService;

    @RequestMapping(value = "/marks/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Marks> getUserType(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Marks marks = marksService.getMarks(id);
        if (marks == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Marks>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Marks>(marks, HttpStatus.OK);
    }
}
