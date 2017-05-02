package com.genezis.service;

import com.genezis.dao.M2MGroupTimeteableDAO;
import com.genezis.model.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by vadim on 20.04.17.
 */
@Service("groupTimetable")
@Transactional
public class M2MGroupTimetableServiceImpl implements M2MGroupTimetableService{

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private M2MGroupTimeteableDAO m2MGroupTimeteableDAO = context.getBean(M2MGroupTimeteableDAO.class);
    @Override
    public M2MGroupTimeteable getGroupTimetable(int id) {
        return m2MGroupTimeteableDAO.getM2MGroupTimeteable(id);
    }

    @Override
    public List<Timeteable> getListTimeteablesToStudents(int id) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        Time time = new Time(24);
        time.setTime(date.getTime());
        List<Timeteable> list = new ArrayList<>();
        for (M2MGroupTimeteable m2MGroupTimeteable : m2MGroupTimeteableDAO.getTimetablesToStudent(id, time, date)){
            list.add(m2MGroupTimeteable.getIdTimeteable());
        }
        return list;
    }

    @Override
    public List<ListSubjectsToProfessor> getListSubjectToProfessor(int idGroup) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        Time time = new Time(24);
        time.setTime(date.getTime());
        List<MyUser> list = new ArrayList<>();
        for (M2MGroupTimeteable m2MGroupTimeteable : m2MGroupTimeteableDAO.getTimetablesToStudent(idGroup, time, date)){
            list.add(m2MGroupTimeteable.getIdTimeteable().getMyUser());
        }
        List<MyUser> myUserList = new ArrayList<>();
        for (MyUser myUser : list) {
            if (!ifExistsInList(myUserList, myUser)) {
                myUserList.add(myUser);
            }
        }
        ListSubjectsToProfessor listSubjectsToProfessor = new ListSubjectsToProfessor();
        List<ListSubjectsToProfessor> listSubjectsToProfessors = new ArrayList<>();
        List<Subject> subjects = new ArrayList<>();
        for (MyUser professor : myUserList){
            listSubjectsToProfessor.setMyUser(professor);
            for (M2MGroupTimeteable m2MGroupTimeteable : m2MGroupTimeteableDAO.getTimetablesToStudentInQueue(idGroup, professor.getIdUser())){
                if (!ifExistsSubjectInList(subjects, m2MGroupTimeteable.getIdTimeteable().getSubject())) {
                    subjects.add(m2MGroupTimeteable.getIdTimeteable().getSubject());
                }
            }
            listSubjectsToProfessor.setSubjects(subjects);
        listSubjectsToProfessors.add(listSubjectsToProfessor);
        }
        return listSubjectsToProfessors;
    }

    private boolean ifExistsInList(List<MyUser> myUsers, MyUser myUser){
        for (int i = 0; i < myUsers.size(); i++){
            if (myUsers.get(i).getIdUser() == myUser.getIdUser()){
                return true;
            }
        }
        return false;
    }

    private boolean ifExistsSubjectInList(List<Subject> subjects, Subject subject){
        for (int i = 0; i < subjects.size(); i++){
            if (subjects.get(i).getIdSubject() == subject.getIdSubject()){
                return true;
            }
        }
        return false;
    }
}
