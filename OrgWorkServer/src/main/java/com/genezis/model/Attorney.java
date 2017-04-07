package com.genezis.model;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name="ATTORNEY")
public class Attorney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idAttorney;

    @ManyToOne
        @JoinColumn(name = "IdTypeOfAttorney")
    private
    TypeOfAttorney typeOfAttorney;

    @ManyToOne
        @JoinColumn(name = "IdSubject")
    private
    Subject subject;

    @ManyToOne
        @JoinColumn(name = "IdUserProfessor")
    private
    myUser idMyUserProfessor;

    @ManyToOne
        @JoinColumn(name = "IdUserStudent")
    private
    myUser idMyUserStudent;

    public int getIdAttorney() {
        return idAttorney;
    }

    public void setIdAttorney(int idAttorney) {
        this.idAttorney = idAttorney;
    }

    public TypeOfAttorney getTypeOfAttorney() {
        return typeOfAttorney;
    }

    public void setTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        this.typeOfAttorney = typeOfAttorney;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public myUser getIdMyUserProfessor() {
        return idMyUserProfessor;
    }

    public void setIdMyUserProfessor(myUser idMyUserProfessor) {
        this.idMyUserProfessor = idMyUserProfessor;
    }

    public myUser getIdMyUserStudent() {
        return idMyUserStudent;
    }

    public void setIdMyUserStudent(myUser idMyUserStudent) {
        this.idMyUserStudent = idMyUserStudent;
    }
}
