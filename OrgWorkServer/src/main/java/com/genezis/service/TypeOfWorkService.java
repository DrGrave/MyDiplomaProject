package com.genezis.service;

import com.genezis.model.TypeOfWork;

/**
 * Created by vadim on 03.04.17.
 */
public interface TypeOfWorkService {
    void saveTypeOfWork(TypeOfWork typeOfWork);
    TypeOfWork getTypeOfWork(int id);
    TypeOfWork editTypeOfWork(TypeOfWork typeOfWork);
    void deleteTypeOfWork(TypeOfWork typeOfWork);
    TypeOfWork ifExists(TypeOfWork typeOfWork);
}
