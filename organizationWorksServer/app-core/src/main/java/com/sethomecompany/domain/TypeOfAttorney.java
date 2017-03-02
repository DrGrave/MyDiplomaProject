package com.sethomecompany.domain;

/**
 * Created by Vadim on 11.12.2016.
 */
public class TypeOfAttorney {
    Integer idTypeOfAttorney;
    String nameOfAttorney;

    public TypeOfAttorney(Integer idTypeOfAttorney, String nameOfAttorney) {
        this.idTypeOfAttorney = idTypeOfAttorney;
        this.nameOfAttorney = nameOfAttorney;
    }

    public TypeOfAttorney() {
    }

    public Integer getIdTypeOfAttorney() {

        return idTypeOfAttorney;
    }

    public void setIdTypeOfAttorney(Integer idTypeOfAttorney) {
        this.idTypeOfAttorney = idTypeOfAttorney;
    }

    public String getNameOfAttorney() {
        return nameOfAttorney;
    }

    public void setNameOfAttorney(String nameOfAttorney) {
        this.nameOfAttorney = nameOfAttorney;
    }
}
