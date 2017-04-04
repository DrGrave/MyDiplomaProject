package com.genezis.dao;

import com.genezis.model.TypeInClass;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface TypeInClassDAO {
    public void saveTypeInClass(TypeInClass typeInClass);
    public List<TypeInClass> listTypeInClass();
    public TypeInClass getTypeInClass(int id);
    public TypeInClass editTypeInClass(TypeInClass typeInClass);
    void deleteTypeInClass(TypeInClass typeInClass);
}
