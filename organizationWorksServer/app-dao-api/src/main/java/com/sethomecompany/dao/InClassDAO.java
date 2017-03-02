package com.sethomecompany.dao;

import com.sethomecompany.domain.InClass;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public interface InClassDAO {
    Integer addInClass(InClass inClass);
    void deleteInClass(InClass inClass);
    InClass getInClass(Integer userID);
    List<InClass> getAllInClassFowUser(Integer userID);
}
