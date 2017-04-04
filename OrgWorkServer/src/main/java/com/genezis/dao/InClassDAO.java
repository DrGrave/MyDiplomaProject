package com.genezis.dao;

import com.genezis.model.InClass;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface InClassDAO {
    void saveInClass(InClass inClass);
    List<InClass> listInClass();
    InClass getInClass(int id);
    InClass editInClass(InClass inClass);
    void deleteInClass(InClass inClass);
}
