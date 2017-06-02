package com.genezis.service;

import com.genezis.model.M2MStudentWork;
import com.genezis.model.Subject;
import com.genezis.model.Work;

import java.util.List;

/**
 * Created by Vadim on 12.04.2017.
 */
public interface M2MStudentWorkService {
    List<Subject> getListSubjects(int idUser);

    List<Work> getListWorks(int id, int idUser);

    M2MStudentWork getM2MStudentWork(int id, int idUser);
}
