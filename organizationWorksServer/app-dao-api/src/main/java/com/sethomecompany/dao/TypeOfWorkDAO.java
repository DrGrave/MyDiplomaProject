package com.sethomecompany.dao;

import com.sethomecompany.domain.TypeOfwork;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public interface TypeOfWorkDAO {
    List<TypeOfwork> getAllTypeOfwork();
    Integer addTypeOfwork(TypeOfwork typeOfwork);
    void deleteTypeOfwork(TypeOfwork typeOfwork);
    TypeOfwork getTypeOfwork(Integer idTypeOfwork);
}
