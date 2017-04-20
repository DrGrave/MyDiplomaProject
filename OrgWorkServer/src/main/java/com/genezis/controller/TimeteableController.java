package com.genezis.controller;
import com.genezis.dao.TimeteableDAO;
import com.genezis.model.Timeteable;
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
public class TimeteableController {
    @Autowired
    TimeteableDAO timeteableDAO;

    @RequestMapping(value = "/timeteable/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Timeteable> getUserType(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Timeteable timeteable = timeteableDAO.getTimeteable(id);
        if (timeteable == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Timeteable>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Timeteable>(timeteable, HttpStatus.OK);
    }
}
