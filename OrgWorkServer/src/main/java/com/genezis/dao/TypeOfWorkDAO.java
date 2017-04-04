package com.genezis.dao;

import com.genezis.model.TypeOfWork;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface TypeOfWorkDAO {
    public void saveTypeOfWork(TypeOfWork typeOfWork);
    public List<TypeOfWork> listTypeOfWork();
    public TypeOfWork getTypeOfWork(int id);
    public TypeOfWork editTypeOfWork(TypeOfWork typeOfWork);
    void deleteTypeOfWork(TypeOfWork typeOfWork);
}
