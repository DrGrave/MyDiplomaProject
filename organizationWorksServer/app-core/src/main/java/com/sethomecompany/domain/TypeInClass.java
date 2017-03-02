package com.sethomecompany.domain;

/**
 * Created by Vadim on 11.12.2016.
 */
public class TypeInClass {
    Integer idTypeinclass;
    String nameInClass;

    public TypeInClass(Integer idTypeinclass, String nameInClass) {
        this.idTypeinclass = idTypeinclass;
        this.nameInClass = nameInClass;
    }

    public TypeInClass() {
    }

    public Integer getIdTypeinclass() {
        return idTypeinclass;
    }

    public void setIdTypeinclass(Integer idTypeinclass) {
        this.idTypeinclass = idTypeinclass;
    }

    public String getNameInClass() {
        return nameInClass;
    }

    public void setNameInClass(String nameInClass) {
        this.nameInClass = nameInClass;
    }
}
