package com.sethomecompany.domain;

/**
 * Created by Vadim on 11.12.2016.
 */
public class Queue {
    Integer idInQueue;
    User userInQueue;
    Work work;
    Timeteable timeteable;

    public Queue(Integer idInQueue, User userInQueue, Work work, Timeteable timeteable) {
        this.idInQueue = idInQueue;
        this.userInQueue = userInQueue;
        this.work = work;
        this.timeteable = timeteable;
    }

    public Queue() {
    }

    public Integer getIdInQueue() {
        return idInQueue;
    }

    public void setIdInQueue(Integer idInQueue) {
        this.idInQueue = idInQueue;
    }

    public User getUserInQueue() {
        return userInQueue;
    }

    public void setUserInQueue(User userInQueue) {
        this.userInQueue = userInQueue;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Timeteable getTimeteable() {
        return timeteable;
    }

    public void setTimeteable(Timeteable timeteable) {
        this.timeteable = timeteable;
    }
}
