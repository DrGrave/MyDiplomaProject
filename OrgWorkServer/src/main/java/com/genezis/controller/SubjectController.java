package com.genezis.controller;

import com.genezis.model.Subject;
import com.genezis.service.M2MGroupTimetableService;
import com.genezis.service.M2MProfessorSubjectService;
import com.genezis.service.SubjectService;
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
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private M2MProfessorSubjectService m2MProfessorSubjectService;

    @Autowired
    private M2MGroupTimetableService groupTimetableService;

    @RequestMapping(value = "/subject/professor/list/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Subject>> listSubjectsToProfessor(@PathVariable("id") int id) {
        System.out.print(id);
        List<Subject> subjects = m2MProfessorSubjectService.getListSubjectToProfessor(id);
        if(subjects.isEmpty()){
            return new ResponseEntity<List<Subject>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
    }

    @RequestMapping(value = "/subject/student/list/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Subject>> listSubjectsToStudentMarks(@PathVariable("id") int id){
        List<Subject> subjects = groupTimetableService.getListSubjectToStudent(id);
        if(subjects.isEmpty()){
            return new ResponseEntity<List<Subject>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
    }
}
