package com.genezis.dao;

import com.genezis.model.TypeInClass;


import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface TypeInClassDAO {
    void saveTypeInClass(TypeInClass typeInClass);
    List<TypeInClass> listTypeInClass();
    TypeInClass getTypeInClass(int id);
    TypeInClass editTypeInClass(TypeInClass typeInClass);
    void deleteTypeInClass(TypeInClass typeInClass);
    TypeInClass ifExistsTypeInClass(TypeInClass typeInClass);
}
