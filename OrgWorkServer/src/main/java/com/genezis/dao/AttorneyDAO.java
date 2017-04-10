package com.genezis.dao;

import com.genezis.model.Attorney;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface AttorneyDAO {
    void saveAttorney(Attorney attorney);
    List<Attorney> listAttorney();
    Attorney getAttorneyById(int id);
    Attorney editAttorney(Attorney attorney);
    void deleteAttorney(Attorney attorney);
    Attorney ifExistsAttorney(Attorney attorney);
}
