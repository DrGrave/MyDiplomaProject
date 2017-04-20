package com.genezis.controller;
import com.genezis.model.TypeOfAttorney;
import com.genezis.service.TypeOfAttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TypeOfAttorneyController {
    @Autowired
    private TypeOfAttorneyService typeOfAttorneyService;


    /* GET */
    @RequestMapping(value = "/typeOfAttorney/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TypeOfAttorney> getTypeOfAttorney(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        TypeOfAttorney typeOfAttorney = typeOfAttorneyService.getTypeOfAttorney(id);
        if (typeOfAttorney == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<TypeOfAttorney>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TypeOfAttorney>(typeOfAttorney, HttpStatus.OK);
    }
}
