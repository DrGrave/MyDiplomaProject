package com.genezis.controller;


import com.genezis.model.CommentToWork;
import com.genezis.model.Queue;
import com.genezis.model.Work;
import com.genezis.service.CommentToWorkService;
import com.genezis.service.QueueService;
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
public class QueueController {
    @Autowired
    private QueueService queueService;

    @Autowired
    private CommentToWorkService commentToWorkService;

    @RequestMapping(value = "/queue/list/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Queue>> listAllUsers(@PathVariable("id") int id) {
        System.out.print(id);
        List<Queue> queues = queueService.getListToProfessorById(id);
        if(queues.isEmpty()){
            return new ResponseEntity<List<Queue>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Queue>>(queues, HttpStatus.OK);
    }

    @RequestMapping(value = "/queue/professor/{idProf}/work/{idWork}/student/{idStudent}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Queue> listAllUsers(@PathVariable("idProf") int id, @PathVariable("idWork") int idWork, @PathVariable("idStudent") int idStudent) {
        System.out.print(id);
        Queue queue = queueService.getListToProfessorByIdWorkStudent(id, idWork, idStudent);
        if(queue == null){
            return new ResponseEntity<Queue>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Queue>(queue, HttpStatus.OK);
    }

    @RequestMapping(value = "/queue/listworks/student/{id}/professor/{idprof}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Work>> listWorks(@PathVariable("id") int id, @PathVariable("idprof") int idprof){
        List<Work> workList = queueService.listWorksToStudentById(id, idprof);
        if(workList.isEmpty()){
            return new ResponseEntity<List<Work>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Work>>(workList, HttpStatus.OK);
    }

    @RequestMapping(value = "/queue/listcommentsworks/{idWork}/user/{idUser}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentToWork>> listCommentsToWork(@PathVariable("idWork") int idWork, @PathVariable("idUser") int idUser) {
        List<CommentToWork> commentToWorksList = commentToWorkService.listOfCommentsToUserWorks(idUser, idWork);
        if (commentToWorksList.isEmpty()) {
            return new ResponseEntity<List<CommentToWork>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<CommentToWork>>(commentToWorksList, HttpStatus.OK);
    }

    @RequestMapping(value = "/queue/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Queue> deleteUser(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting queue with id " + id);
        Queue queue = queueService.getQueue(id);
        if (queue == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Queue>(HttpStatus.NOT_FOUND);
        }
        queueService.deleteQueue(queue);
        return new ResponseEntity<Queue>(HttpStatus.NO_CONTENT);
    }
}
