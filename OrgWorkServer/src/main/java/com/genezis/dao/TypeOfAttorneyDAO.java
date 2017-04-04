package com.genezis.dao;

import com.genezis.model.TypeOfAttorney;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface TypeOfAttorneyDAO {
    public void saveTypeOfAttorney(TypeOfAttorney typeOfAttorney);
    public List<TypeOfAttorney> listTypeOfAttorney();
    public TypeOfAttorney getTypeOfAttorney(int id);
    public TypeOfAttorney editTypeOfAttorney(TypeOfAttorney typeOfAttorney);
    void deleteTypeOfAttorney(TypeOfAttorney typeOfAttorney);
}
