package com.genezis.dao;

import com.genezis.model.Attorney;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface AttorneyDAO {
    public void saveAttorney(Attorney attorney);
    public List<Attorney> listAttorney();
    public Attorney getAttorneyById(int id);
    public Attorney editAttorney(Attorney attorney);
    public void deleteAttorney(Attorney attorney);
}
