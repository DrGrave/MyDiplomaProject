package com.genezis.controller;
import com.genezis.dao.TypeOfWorkDAO;
import com.genezis.model.TypeOfWork;
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
public class TypeOfWorkController {
    @Autowired
    private
    TypeOfWorkDAO typeOfWorkDAO;


    /* GET */
    @RequestMapping(value = "/typeOfWork/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TypeOfWork> getUserType(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        TypeOfWork typeOfWork = typeOfWorkDAO.getTypeOfWork(id);
        if (typeOfWork == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<TypeOfWork>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TypeOfWork>(typeOfWork, HttpStatus.OK);
    }
}
