package com.sethomecompany.dao;

import com.sethomecompany.domain.Recension;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public interface RecensionDAO {
    List<Recension> getAllRecension();

    List<Recension> getAllStudentsByQueueId(Integer id);

    Recension getRecensionById(Integer recensionId);


    Integer addRecension(Recension recension);

    void updateRecension(Recension recension);

    void deleteRecension(Recension recension);

    void deleteRecensionById(Integer id);
}
