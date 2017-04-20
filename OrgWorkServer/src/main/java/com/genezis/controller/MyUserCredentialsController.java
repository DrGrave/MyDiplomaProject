package com.genezis.controller;

import com.genezis.model.MyUserCredentials;
import com.genezis.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Vadim on 11.04.2017.
 */
@RestController
public class MyUserCredentialsController {
    @Autowired
    private UserCredentialsService userCredentialsService;

    @RequestMapping(value = "/myUserCredentials/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> getMyUserCredential(@RequestBody MyUserCredentials myUserCredentials, UriComponentsBuilder ucBuilder) throws NoSuchAlgorithmException {
        System.out.println("Try to get Credentials" + myUserCredentials.getUserLogin());
        if (userCredentialsService.getUserCredentialsByLP(myUserCredentials.getUserLogin(), myUserCredentials.getUserPassword()) == null) {
            System.out.println("there is no user credentials");
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/myUserCredentials/{id}").buildAndExpand(userCredentialsService.getUserCredentialsByLP(myUserCredentials.getUserLogin(), myUserCredentials.getUserPassword()).getMyUser().getIdUser()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
}
