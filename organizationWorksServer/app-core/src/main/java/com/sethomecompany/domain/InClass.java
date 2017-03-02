package com.sethomecompany.domain;


/**
 * Created by Vadim on 11.12.2016.
 */
public class InClass {
    Integer idInClass;
    User userInClass;
    TypeInClass typeInClass;
    Timeteable timeteable;

    public InClass(Integer idInClass, User userInClass, TypeInClass typeInClass, Timeteable timeteable) {
        this.idInClass = idInClass;
        this.userInClass = userInClass;
        this.typeInClass = typeInClass;
        this.timeteable = timeteable;
    }

    public InClass() {
    }

    public User getUserInClass() {
        return userInClass;
    }

    public void setUserInClass(User userInClass) {
        this.userInClass = userInClass;
    }

    public Integer getIdInClass() {
        return idInClass;
    }

    public void setIdInClass(Integer idInClass) {
        this.idInClass = idInClass;
    }


    public TypeInClass getTypeInClass() {
        return typeInClass;
    }

    public void setTypeInClass(TypeInClass typeInClass) {
        this.typeInClass = typeInClass;
    }

    public Timeteable getTimeteable() {
        return timeteable;
    }

    public void setTimeteable(Timeteable timeteable) {
        this.timeteable = timeteable;
    }
}
