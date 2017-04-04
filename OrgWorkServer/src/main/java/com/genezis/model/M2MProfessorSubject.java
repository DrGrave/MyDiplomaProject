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
    User idUserM2M;

    @ManyToOne
    @JoinColumn(name = "IdSubject")
    Subject idSubjectM2M;

    public User getIdUserM2M() {
        return idUserM2M;
    }

    public void setIdUserM2M(User idUserM2M) {
        this.idUserM2M = idUserM2M;
    }

    public Subject getIdSubjectM2M() {
        return idSubjectM2M;
    }

    public void setIdSubjectM2M(Subject idSubjectM2M) {
        this.idSubjectM2M = idSubjectM2M;
    }
}
