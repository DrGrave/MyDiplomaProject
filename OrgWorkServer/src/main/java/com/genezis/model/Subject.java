package com.genezis.model;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name="SUBJECT")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idSubject;

    @Column(name = "NameSubject")
    String nameSubject;

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSubject=" + idSubject +
                ", nameSubject='" + nameSubject + '\'' +
                '}';
    }
}
