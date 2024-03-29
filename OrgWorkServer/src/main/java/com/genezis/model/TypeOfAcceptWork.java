package com.genezis.model;

import javax.persistence.*;

/**
 * Created by Vadim on 12.04.2017.
 */
@Entity
@Table(name="TypeOfAccaptWork")
public class TypeOfAcceptWork {

    public TypeOfAcceptWork() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfAccaptWork;

    @Column(name = "NameOfAccaptWork")
    private String nameOfAccaptWork;

    public int getIdOfAccaptWork() {
        return idOfAccaptWork;
    }

    public void setIdOfAccaptWork(int idOfAccaptWork) {
        this.idOfAccaptWork = idOfAccaptWork;
    }

    public String getNameOfAccaptWork() {
        return nameOfAccaptWork;
    }

    public void setNameOfAccaptWork(String nameOfAccaptWork) {
        this.nameOfAccaptWork = nameOfAccaptWork;
    }
}
