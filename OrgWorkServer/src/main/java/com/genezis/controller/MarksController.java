package com.genezis.controller;
import com.genezis.model.Marks;
import com.genezis.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
public class MarksController {
    @Autowired
    private MarksService marksService;

    @RequestMapping(value = "/marks/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Marks> getMarkById(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Marks marks = marksService.getMarks(id);
        if (marks == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Marks>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Marks>(marks, HttpStatus.OK);
    }

    @RequestMapping(value = "/marks/", method = RequestMethod.POST)
    public ResponseEntity<Void> createWork(@RequestBody Marks marks, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Work " + marks.getMark());
        if (marksService.ifExists(marks) != null) {
            System.out.println("A work with name " + marks.getMark() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        marksService.saveMarks(marks);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/marks/{id}").buildAndExpand(marks.getIdMarks()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/subject/marks/list/{User}/subject/{idSubject}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Marks>> getListMarks(@PathVariable("User") int idUser, @PathVariable("idSubject") int idSubject) {
        List<Marks> marks = marksService.getListMarks(idUser, idSubject);
        if (marks == null) {
            return new ResponseEntity<List<Marks>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Marks>>(marks, HttpStatus.OK);
    }

}
