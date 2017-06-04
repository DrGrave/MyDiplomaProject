package com.genezis.dao;

import com.genezis.model.M2MStudentWork;
import com.genezis.model.Subject;
import com.genezis.model.Work;

import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
public interface M2MStudentWorkDAO {
    void saveM2MStudentWork(M2MStudentWork m2mStudentWork);
    List<M2MStudentWork> listM2MStudentWork();
    M2MStudentWork getM2MStudentWork(int id);
    M2MStudentWork editM2MStudentWork(M2MStudentWork m2mStudentWork);
    void deleteM2MStudentWork(M2MStudentWork m2mStudentWork);
    List<M2MStudentWork> getListSubjectsToWorksStudent(int idUser);

    List<M2MStudentWork> getListOfWorksToStudent(int id, int idUser);

    M2MStudentWork getM2MStudentWorkInfo(int id, int idUser);
}
