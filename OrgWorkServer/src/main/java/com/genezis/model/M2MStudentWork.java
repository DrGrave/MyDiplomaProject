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
    private MyUser studentToWork;

    public Work getStudentWork() {
        return studentWork;
    }

    public void setStudentWork(Work studentWork) {
        this.studentWork = studentWork;
    }

    public MyUser getStudentToWork() {
        return studentToWork;
    }

    public void setStudentToWork(MyUser studentToWork) {
        this.studentToWork = studentToWork;
    }
}
