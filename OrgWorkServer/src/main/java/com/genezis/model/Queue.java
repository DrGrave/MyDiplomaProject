package com.genezis.model;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name = "Queue")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQueue;

    @ManyToOne
    @JoinColumn(name = "IdUSer")
    private myUser myUser;

    @ManyToOne
    @JoinColumn(name = "IdTimeteable")
    private Timeteable timeteable;

    @ManyToOne
    @JoinColumn(name = "IdOfWork")
    private Work work;

    public int getIdQueue() {
        return idQueue;
    }

    public void setIdQueue(int idQueue) {
        this.idQueue = idQueue;
    }

    public myUser getMyUser() {
        return myUser;
    }

    public void setMyUser(myUser myUser) {
        this.myUser = myUser;
    }

    public Timeteable getTimeteable() {
        return timeteable;
    }

    public void setTimeteable(Timeteable timeteable) {
        this.timeteable = timeteable;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "idQueue=" + idQueue +
                ", myUser=" + myUser +
                ", timeteable=" + timeteable +
                ", work=" + work +
                '}';
    }
}
