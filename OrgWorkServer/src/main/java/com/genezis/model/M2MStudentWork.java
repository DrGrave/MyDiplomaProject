package com.genezis.model;

import javax.persistence.*;

/**
 * Created by Vadim on 04.04.2017.
 */
@Entity
@Table(name = "m2m_student_work")
public class M2MStudentWork {
    @ManyToOne
            @JoinColumn(name = "IdOfWork")
    private Work studentWork;

    @ManyToOne
            @JoinColumn(name = "IdUser")
    private myUser studentToWork;

    public Work getStudentWork() {
        return studentWork;
    }

    public void setStudentWork(Work studentWork) {
        this.studentWork = studentWork;
    }

    public myUser getStudentToWork() {
        return studentToWork;
    }

    public void setStudentToWork(myUser studentToWork) {
        this.studentToWork = studentToWork;
    }
}
