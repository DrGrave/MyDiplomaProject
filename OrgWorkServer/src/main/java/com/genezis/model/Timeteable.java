package com.genezis.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name = "Timeteable")
public class Timeteable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTimeteable;

    @Column(name = "DateOfWork")
    private Date date;

    @Column(name = "TimeOfWork")
    private Time time;

    @Column(name = "TimeOfEndWork")
    private Time timeToEnd;

    @OneToOne
    @JoinColumn(name = "IdUser")
    private myUser myUser;

    @OneToOne
    @JoinColumn(name = "IdSubject")
    private Subject subject;

    public int getIdTimeteable() {
        return idTimeteable;
    }

    public void setIdTimeteable(int idTimeteable) {
        this.idTimeteable = idTimeteable;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTimeToEnd() {
        return timeToEnd;
    }

    public void setTimeToEnd(Time timeToEnd) {
        this.timeToEnd = timeToEnd;
    }

    public myUser getMyUser() {
        return myUser;
    }

    public void setMyUser(myUser myUser) {
        this.myUser = myUser;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Timeteable{" +
                "idTimeteable=" + idTimeteable +
                ", date=" + date +
                ", time=" + time +
                ", timeToEnd=" + timeToEnd +
                ", myUser=" + myUser +
                ", subject=" + subject +
                '}';
    }
}
