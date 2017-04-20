package com.genezis.controller;


import com.genezis.model.UserType;
import com.genezis.service.UserTypeService;
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
public class UserTypeController {
    @Autowired
    private UserTypeService userTypeService;


    /* GET */
    @RequestMapping(value = "/userType/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserType> getUserType(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        UserType userType = userTypeService.getUserTypeById(id);
        if (userType == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<UserType>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserType>(userType, HttpStatus.OK);
    }

    @RequestMapping(value = "/userType/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody UserType userType,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating UserType " + userType.getNameUserType());
        if (userTypeService.ifExists(userType)) {
            System.out.println("A UserType with name " + userType.getNameUserType() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        userTypeService.saveUserType(userType);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/userType/{id}").buildAndExpand(userType.getIdUserType()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
