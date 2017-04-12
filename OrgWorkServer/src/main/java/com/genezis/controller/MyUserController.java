package com.genezis.controller;

import com.genezis.model.MyUser;
import com.genezis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vadim on 11.04.2017.
 */
@RestController
public class MyUserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MyUser> getUser(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        MyUser user = userService.getMyUserById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<MyUser>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MyUser>(user, HttpStatus.OK);
    }
}
