package com.genezis.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vadim on 04.04.2017.
 */
@Entity
@Table(name = "M2M_Student_Work")
public class M2MStudentWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int idM2MStudentWork;

    @ManyToOne
            @JoinColumn(name = "IdOfWork")
    private Work idOfWork;

    @ManyToOne
            @JoinColumn(name = "IdUser")
    private MyUser idUser;

    @ManyToOne
            @JoinColumn(name = "IdTypeOfAccepted")
    private TypeOfAcceptWork idOfAccaptWork;

    public int getIdM2MStudentWork() {
        return idM2MStudentWork;
    }

    public void setIdM2MStudentWork(int idM2MStudentWork) {
        this.idM2MStudentWork = idM2MStudentWork;
    }

    public TypeOfAcceptWork getIdOfAccaptWork() {
        return idOfAccaptWork;
    }

    public void setIdOfAccaptWork(TypeOfAcceptWork idOfAccaptWork) {
        this.idOfAccaptWork = idOfAccaptWork;
    }

    public Work getIdOfWork() {
        return idOfWork;
    }

    public void setIdOfWork(Work idOfWork) {
        this.idOfWork = idOfWork;
    }

    public MyUser getIdUser() {
        return idUser;
    }

    public void setIdUser(MyUser idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
