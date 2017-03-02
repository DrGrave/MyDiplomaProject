package com.sethomecompany.domain;

/**
 * Created by Vadim on 11.12.2016.
 */
public class Work {
    Integer idWork;
    Integer numberOfWork;
    String nameOfWork;
    String textOfWork;
    Subject subject;
    TypeOfwork typeOfwork;

    public Work(Integer idWork, Integer numberOfWork, String nameOfWork, String textOfWork, Subject subject, TypeOfwork typeOfwork) {
        this.idWork = idWork;
        this.numberOfWork = numberOfWork;
        this.nameOfWork = nameOfWork;
        this.textOfWork = textOfWork;
        this.subject = subject;
        this.typeOfwork = typeOfwork;
    }

    public Work() {
    }

    public Integer getIdWork() {
        return idWork;
    }

    public void setIdWork(Integer idWork) {
        this.idWork = idWork;
    }

    public Integer getNumberOfWork() {
        return numberOfWork;
    }

    public void setNumberOfWork(Integer numberOfWork) {
        this.numberOfWork = numberOfWork;
    }

    public String getNameOfWork() {
        return nameOfWork;
    }

    public void setNameOfWork(String nameOfWork) {
        this.nameOfWork = nameOfWork;
    }

    public String getTextOfWork() {
        return textOfWork;
    }

    public void setTextOfWork(String textOfWork) {
        this.textOfWork = textOfWork;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public TypeOfwork getTypeOfwork() {
        return typeOfwork;
    }

    public void setTypeOfwork(TypeOfwork typeOfwork) {
        this.typeOfwork = typeOfwork;
    }
}
