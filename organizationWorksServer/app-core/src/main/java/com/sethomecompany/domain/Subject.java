package com.sethomecompany.domain;

/**
 * Created by Vadim on 11.12.2016.
 */
public class Subject {
    Integer idSubject;
    String nameOfSubject;

    public Subject(Integer idSubject, String nameOfSubject) {
        this.idSubject = idSubject;
        this.nameOfSubject = nameOfSubject;
    }

    public Subject() {
    }

    public Integer getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }
}
