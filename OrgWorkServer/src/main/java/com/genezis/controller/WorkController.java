package com.genezis.controller;

import com.genezis.service.WorkService;
import com.genezis.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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


}
