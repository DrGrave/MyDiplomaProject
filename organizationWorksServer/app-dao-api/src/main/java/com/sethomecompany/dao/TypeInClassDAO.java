package com.sethomecompany.dao;

import com.sethomecompany.domain.TypeInClass;

import java.util.List;


/**
 * Created by Vadim on 12.12.2016.
 */
public interface TypeInClassDAO {
    List<TypeInClass> getAllTypeInClass();
    Integer addTypeInClass(TypeInClass typeInClass);
    void deleteTypeInClass(TypeInClass typeInClass);
    TypeInClass getTypeInClass(Integer idTypeInClass);
}
