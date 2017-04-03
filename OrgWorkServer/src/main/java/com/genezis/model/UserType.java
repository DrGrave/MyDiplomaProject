package com.genezis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name="UserType")
public class UserType {
    @Id
    @Column(name="IdUserType")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int idUserType;

    @Column(name = "NameUserType")
    String nameUserType;

    public int getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(int idUserType) {
        this.idUserType = idUserType;
    }

    public String getNameUserType() {
        return nameUserType;
    }

    public void setNameUserType(String nameUserType) {
        this.nameUserType = nameUserType;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "idUserType=" + idUserType +
                ", nameUserType='" + nameUserType + '\'' +
                '}';
    }
}
