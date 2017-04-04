package com.genezis.dao;

import com.genezis.model.TypeOfWork;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface TypeOfWorkDAO {
    void saveTypeOfWork(TypeOfWork typeOfWork);
    List<TypeOfWork> listTypeOfWork();
    TypeOfWork getTypeOfWork(int id);
    TypeOfWork editTypeOfWork(TypeOfWork typeOfWork);
    void deleteTypeOfWork(TypeOfWork typeOfWork);
}
