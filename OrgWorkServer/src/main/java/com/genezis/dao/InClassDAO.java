package com.genezis.dao;

import com.genezis.model.InClass;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface InClassDAO {
    public void saveInClass(InClass inClass);
    public List<InClass> listInClass();
    public InClass getInClass(int id);
    public InClass editInClass(InClass inClass);
}
