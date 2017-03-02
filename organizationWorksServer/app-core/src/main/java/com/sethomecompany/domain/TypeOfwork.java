package com.sethomecompany.domain;

/**
 * Created by Vadim on 11.12.2016.
 */
public class TypeOfwork {
    Integer idTypeOfWork;
    String nameTypeOfWork;

    public TypeOfwork(Integer idTypeOfWork, String nameTypeOfWork) {
        this.idTypeOfWork = idTypeOfWork;
        this.nameTypeOfWork = nameTypeOfWork;
    }

    public TypeOfwork() {
    }

    public Integer getIdTypeOfWork() {
        return idTypeOfWork;
    }

    public void setIdTypeOfWork(Integer idTypeOfWork) {
        this.idTypeOfWork = idTypeOfWork;
    }

    public String getNameTypeOfWork() {
        return nameTypeOfWork;
    }

    public void setNameTypeOfWork(String nameTypeOfWork) {
        this.nameTypeOfWork = nameTypeOfWork;
    }
}
