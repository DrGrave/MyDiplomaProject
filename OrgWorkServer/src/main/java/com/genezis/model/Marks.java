package com.genezis.model;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name = "Marks")
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMarks;

    @Column(name = "Mark")
    private int mark;

    @OneToOne
    @JoinColumn(name = "IdTimeteable")
    private Timeteable timeteable;

    @OneToOne
    @JoinColumn(name = "IdUser")
    private User user;

    @OneToOne
    @JoinColumn(name = "IdOfWork")
    private Work work;

    public int getIdMarks() {
        return idMarks;
    }

    public void setIdMarks(int idMarks) {
        this.idMarks = idMarks;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Timeteable getTimeteable() {
        return timeteable;
    }

    public void setTimeteable(Timeteable timeteable) {
        this.timeteable = timeteable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "idMarks=" + idMarks +
                ", mark=" + mark +
                ", timeteable=" + timeteable +
                ", user=" + user +
                ", work=" + work +
                '}';
    }
}
