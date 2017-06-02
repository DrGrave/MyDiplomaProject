package com.genezis.controller;

import com.genezis.model.M2MStudentWork;
import com.genezis.model.Subject;
import com.genezis.model.Work;
import com.genezis.service.M2MStudentWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Vadim on 29.05.2017.
 */
@RestController
public class M2MStudentWorkController {
    @Autowired
    private M2MStudentWorkService m2MStudentWorkService;

    @RequestMapping(value = "/subject/toStudentWorks/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Subject>> getSubjectsToStudent(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        List<Subject> subjectList = m2MStudentWorkService.getListSubjects(id);
        if (subjectList == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<List<Subject>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.OK);
    }

    @RequestMapping(value = "/workslist/{idSubject}/user/{idUser}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Work>> getWorksToStudent(@PathVariable("idSubject") int id, @PathVariable("idUser") int idUser) {
        System.out.println("Fetching User with id " + id);
        List<Work> works = m2MStudentWorkService.getListWorks(id, idUser);
        if (works == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<List<Work>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Work>>(works, HttpStatus.OK);
    }

    @RequestMapping(value = "/work/{idWork}/user/{idUser}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<M2MStudentWork> getInfoOfWOrksToStudent(@PathVariable("idWork") int id, @PathVariable("idUser") int idUser) {
        System.out.println("Fetching User with id " + id);
        M2MStudentWork m2MStudentWork = m2MStudentWorkService.getM2MStudentWork(id, idUser);
        if (m2MStudentWork == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<M2MStudentWork>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<M2MStudentWork>(m2MStudentWork, HttpStatus.OK);
    }




}
