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
    int idAttorney;

    @ManyToOne
        @JoinColumn(name = "IdTypeOfAttorney")
    TypeOfAttorney typeOfAttorney;

    @ManyToOne
        @JoinColumn(name = "IdSubject")
    Subject subject;

    @ManyToOne
        @JoinColumn(name = "IdUserProfessor")
    User idUserProfessor;

    @ManyToOne
        @JoinColumn(name = "IdUserStudent")
    User idUserStudent;

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

    public User getIdUserProfessor() {
        return idUserProfessor;
    }

    public void setIdUserProfessor(User idUserProfessor) {
        this.idUserProfessor = idUserProfessor;
    }

    public User getIdUserStudent() {
        return idUserStudent;
    }

    public void setIdUserStudent(User idUserStudent) {
        this.idUserStudent = idUserStudent;
    }
}
