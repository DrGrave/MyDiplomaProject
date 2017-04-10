package com.genezis.service;

import com.genezis.model.TypeInClass;

/**
 * Created by vadim on 03.04.17.
 */
public interface TypeInClassService {
    void saveTypeInClass(TypeInClass typeInClass);
    TypeInClass getTypeInClass(int id);
    TypeInClass editTypeInClass(TypeInClass typeInClass);
    void deleteTypeInClass(TypeInClass typeInClass);
    TypeInClass ifExists(TypeInClass typeInClass);
}
