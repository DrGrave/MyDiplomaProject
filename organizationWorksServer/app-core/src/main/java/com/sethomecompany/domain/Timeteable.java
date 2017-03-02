package com.sethomecompany.domain;

import java.util.Date;

/**
 * Created by Vadim on 11.12.2016.
 */
public class Timeteable {
    Integer idTimeteable;
    Date dateOfWork;
    Date timeOfWork;
    Date timeOfEndWork;
    Professor professor;
    String auditory;
    Subject subject;

    public Timeteable(Integer idTimeteable, Date dateOfWork, Date timeOfWork, Date timeOfEndWork, Professor professor, String auditory, Subject subject) {
        this.idTimeteable = idTimeteable;
        this.dateOfWork = dateOfWork;
        this.timeOfWork = timeOfWork;
        this.timeOfEndWork = timeOfEndWork;
        this.professor = professor;
        this.auditory = auditory;
        this.subject = subject;
    }

    public Timeteable() {
    }

    public Integer getIdTimeteable() {
        return idTimeteable;
    }

    public void setIdTimeteable(Integer idTimeteable) {
        this.idTimeteable = idTimeteable;
    }

    public Date getDateOfWork() {
        return dateOfWork;
    }

    public void setDateOfWork(Date dateOfWork) {
        this.dateOfWork = dateOfWork;
    }

    public Date getTimeOfWork() {
        return timeOfWork;
    }

    public void setTimeOfWork(Date timeOfWork) {
        this.timeOfWork = timeOfWork;
    }

    public Date getTimeOfEndWork() {
        return timeOfEndWork;
    }

    public void setTimeOfEndWork(Date timeOfEndWork) {
        this.timeOfEndWork = timeOfEndWork;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getAuditory() {
        return auditory;
    }

    public void setAuditory(String auditory) {
        this.auditory = auditory;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
