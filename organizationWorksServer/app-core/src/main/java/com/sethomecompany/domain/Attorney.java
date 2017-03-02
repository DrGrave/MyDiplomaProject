package com.sethomecompany.domain;

/**
 * Created by Vadim on 11.12.2016.
 */
public class Attorney {
    Integer idAttorney;
    Professor professor;
    User userAttorney;
    Subject subject;
    TypeOfAttorney typeOfAttorney;

    public Attorney(Integer idAttorney, Professor professor, User userAttorney, Subject subject, TypeOfAttorney typeOfAttorney) {
        this.idAttorney = idAttorney;
        this.professor = professor;
        this.userAttorney = userAttorney;
        this.subject = subject;
        this.typeOfAttorney = typeOfAttorney;
    }

    public Attorney() {
    }

    public Integer getIdAttorney() {
        return idAttorney;
    }

    public void setIdAttorney(Integer idAttorney) {
        this.idAttorney = idAttorney;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public User getUserAttorney() {
        return userAttorney;
    }

    public void setUserAttorney(User userAttorney) {
        this.userAttorney = userAttorney;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public TypeOfAttorney getTypeOfAttorney() {
        return typeOfAttorney;
    }

    public void setTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        this.typeOfAttorney = typeOfAttorney;
    }
}
