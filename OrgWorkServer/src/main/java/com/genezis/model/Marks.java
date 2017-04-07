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
    private myUser myUser;

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

    public myUser getMyUser() {
        return myUser;
    }

    public void setMyUser(myUser myUser) {
        this.myUser = myUser;
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
                ", myUser=" + myUser +
                ", work=" + work +
                '}';
    }
}
