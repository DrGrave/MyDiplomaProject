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
    int idM2MStudentWork;

    @ManyToOne
            @JoinColumn(name = "IdOfWork")
    private Work idOfWork;

    @ManyToOne
            @JoinColumn(name = "IdUser")
    private MyUser idUser;

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
}
