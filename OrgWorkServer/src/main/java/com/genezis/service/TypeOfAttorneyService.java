package com.genezis.service;

import com.genezis.model.TypeOfAttorney;

/**
 * Created by vadim on 03.04.17.
 */
public interface TypeOfAttorneyService {
    void saveTypeOfAttorney(TypeOfAttorney typeOfAttorney);
    TypeOfAttorney getTypeOfAttorney(int id);
    TypeOfAttorney editTypeOfAttorney(TypeOfAttorney typeOfAttorney);
    void deleteTypeOfAttorney(TypeOfAttorney typeOfAttorney);
    TypeOfAttorney ifExists(TypeOfAttorney typeOfAttorney);
}
