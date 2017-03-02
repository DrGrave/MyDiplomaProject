package com.sethomecompany.domain;

/**
 * Created by Vadim on 11.12.2016.
 */
public class Marks {
    Integer idMark;
    Integer mark;
    Timeteable timeteable;
    Work work;
    User userOfMark;

    public Marks(Integer idMark, Integer mark, Timeteable timeteable, Work work, User userOfMark) {
        this.idMark = idMark;
        this.mark = mark;
        this.timeteable = timeteable;
        this.work = work;
        this.userOfMark = userOfMark;
    }

    public Marks() {
    }

    public Integer getIdMark() {
        return idMark;
    }

    public void setIdMark(Integer idMark) {
        this.idMark = idMark;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
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

    public User getUserOfMark() {
        return userOfMark;
    }

    public void setUserOfMark(User userOfMark) {
        this.userOfMark = userOfMark;
    }
}
