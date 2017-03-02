package com.sethomecompany.dao;

import com.sethomecompany.domain.Attorney;

/**
 * Created by Vadim on 12.12.2016.
 */
public interface AttorneyDAO {
    Integer addAttorney(Attorney attorney);
    void deleteAttorney(Attorney attorney);
    Attorney getAttorney(Integer userID);
}
