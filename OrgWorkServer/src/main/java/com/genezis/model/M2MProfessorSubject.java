package com.genezis.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Vadim on 04.04.2017.
 */
@Entity
@Table(name = "m2m_professor_subject")
public class M2MProfessorSubject {
    @ManyToOne
    @JoinColumn(name = "IdUser")
    private
    MyUser idMyUserM2M;

    @ManyToOne
    @JoinColumn(name = "IdSubject")
    private
    Subject idSubjectM2M;

    public MyUser getIdMyUserM2M() {
        return idMyUserM2M;
    }

    public void setIdMyUserM2M(MyUser idMyUserM2M) {
        this.idMyUserM2M = idMyUserM2M;
    }

    public Subject getIdSubjectM2M() {
        return idSubjectM2M;
    }

    public void setIdSubjectM2M(Subject idSubjectM2M) {
        this.idSubjectM2M = idSubjectM2M;
    }
}
