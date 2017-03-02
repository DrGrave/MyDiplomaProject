package com.sethomecompany.domain;

/**
 * Created by Vadim on 11.12.2016.
 */
public class Recension {
    Integer idRecension;
    String textRecension;
    Queue queue;
    Integer accapted;
    User userRecension;

    public Recension(Integer idRecension, String textRecension, Queue queue, Integer accapted, User userRecension) {
        this.idRecension = idRecension;
        this.textRecension = textRecension;
        this.queue = queue;
        this.accapted = accapted;
        this.userRecension = userRecension;
    }

    public Recension() {
    }

    public Integer getIdRecension() {
        return idRecension;
    }

    public void setIdRecension(Integer idRecension) {
        this.idRecension = idRecension;
    }

    public String getTextRecension() {
        return textRecension;
    }

    public void setTextRecension(String textRecension) {
        this.textRecension = textRecension;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public Integer getAccapted() {
        return accapted;
    }

    public void setAccapted(Integer accapted) {
        this.accapted = accapted;
    }

    public User getUserRecension() {
        return userRecension;
    }

    public void setUserRecension(User userRecension) {
        this.userRecension = userRecension;
    }
}
