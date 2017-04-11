package com.genezis.dao;

import com.genezis.model.TypeOfAttorney;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface TypeOfAttorneyDAO {
    void saveTypeOfAttorney(TypeOfAttorney typeOfAttorney);
    List<TypeOfAttorney> listTypeOfAttorney();
    TypeOfAttorney getTypeOfAttorney(int id);
    TypeOfAttorney editTypeOfAttorney(TypeOfAttorney typeOfAttorney);
    void deleteTypeOfAttorney(TypeOfAttorney typeOfAttorney);
    TypeOfAttorney ifExistsTypeOfAttorney(TypeOfAttorney typeOfAttorney);
}
