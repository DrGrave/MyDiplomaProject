package com.genezis.controller;

import com.genezis.dao.M2MGroupTimeteableDAO;
import com.genezis.model.M2MGroupTimeteable;
import com.genezis.service.M2MGroupTimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class M2MGroupTimeteableController {
    @Autowired
    private M2MGroupTimetableService groupTimetable;

    @RequestMapping(value = "/timetableGroup/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<M2MGroupTimeteable> getTimetableGroup(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        M2MGroupTimeteable groupTimeteable = groupTimetable.getGroupTimetable(id);
        if (groupTimeteable == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<M2MGroupTimeteable>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<M2MGroupTimeteable>(groupTimeteable, HttpStatus.OK);
    }
}
