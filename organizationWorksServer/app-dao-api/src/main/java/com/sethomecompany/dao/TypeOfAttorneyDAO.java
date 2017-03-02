package com.sethomecompany.dao;

import com.sethomecompany.domain.TypeOfAttorney;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public interface TypeOfAttorneyDAO {
    List<TypeOfAttorney> getAllTypeOfAttorney();
    Integer addTypeOfAttorney(TypeOfAttorney typeOfAttorney);
    void deleteTypeOfAttorney(TypeOfAttorney typeOfAttorney);
    TypeOfAttorney getTypeOfAttorney(Integer idTypeOfAttorney);
}
