package com.genezis.controller;

import com.genezis.model.Queue;
import com.genezis.service.QueueService;
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

import java.util.List;


/**
 * Created by vadim on 03.04.17.
 */
@RestController
public class QueueController {
    @Autowired
    private
    QueueService queueService;

    @RequestMapping(value = "/queue/list/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Queue>> listAllUsers(@PathVariable("id") int id) {
        System.out.print(id);
        List<Queue> users = queueService.getListToProfessorById(id);
        if(users.isEmpty()){
            return new ResponseEntity<List<Queue>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Queue>>(users, HttpStatus.OK);
    }
}
