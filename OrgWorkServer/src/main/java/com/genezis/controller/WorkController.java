package com.genezis.controller;

import com.genezis.service.WorkService;
import com.genezis.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;


@RestController
public class WorkController {
    @Autowired
    private WorkService workService;

    @RequestMapping(value = "/works/list/professor/{professor}/subject/{subject}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Work>> listWorksToProfessor(@PathVariable("professor") int idProfessor, @PathVariable("subject") int idWork) {
        List<Work> works = workService.getWorksByProfessorSubject(idProfessor, idWork);
        if(works.isEmpty()){
            return new ResponseEntity<List<Work>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Work>>(works, HttpStatus.OK);
    }

    @RequestMapping(value = "/work/", method = RequestMethod.POST)
    public ResponseEntity<Void> createWork(@RequestBody Work work, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Work " + work.getNameOfWork());
        if (workService.ifExistsWork(work) != null) {
            System.out.println("A work with name " + work.getNameOfWork() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        workService.saveWork(work);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/work/{id}").buildAndExpand(work.getIdOfWork()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/work/", method = RequestMethod.PUT)
    public ResponseEntity<Work> updateWork(@RequestBody Work work) {
        workService.editWork(work);
        return new ResponseEntity<Work>(work, HttpStatus.OK);
    }

    //------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/work/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Work> deleteUser(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting User with id " + id);
        Work work = workService.getWorkById(id);
        if (work == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Work>(HttpStatus.NOT_FOUND);
        }
        workService.deleteWork(work);
        return new ResponseEntity<Work>(HttpStatus.NO_CONTENT);
    }

}
