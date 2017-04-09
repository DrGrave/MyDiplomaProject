package com.genezis.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Vadim on 04.04.2017.
 */
@Entity
@Table(name = "m2m_group_timeteable")
public class M2MGroupTimeteable {
    @ManyToOne
        @JoinColumn(name = "IdGroup")
    private
    StudentGroup idOfStudentGroupM2M;

    @ManyToOne
        @JoinColumn(name = "IdTimeteable")
    private
    Timeteable idTimeteableM2M;

    public StudentGroup getIdOfStudentGroupM2M() {
        return idOfStudentGroupM2M;
    }

    public void setIdOfStudentGroupM2M(StudentGroup idOfStudentGroupM2M) {
        this.idOfStudentGroupM2M = idOfStudentGroupM2M;
    }

    public Timeteable getIdTimeteableM2M() {
        return idTimeteableM2M;
    }

    public void setIdTimeteableM2M(Timeteable idTimeteableM2M) {
        this.idTimeteableM2M = idTimeteableM2M;
    }
}
