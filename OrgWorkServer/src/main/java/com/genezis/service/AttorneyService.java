package com.genezis.service;


import com.genezis.model.Attorney;

/**
 * Created by vadim on 03.04.17.
 */
public interface AttorneyService{
    void saveAttorney(Attorney attorney);
    Attorney getAttorney(int id);
    Attorney editAttorney(Attorney attorney);
    void deleteAttorney(Attorney attorney);
    Attorney ifExists(Attorney attorney);

}
