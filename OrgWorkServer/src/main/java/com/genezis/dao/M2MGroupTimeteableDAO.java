package com.genezis.dao;

import com.genezis.model.M2MGroupTimeteable;

import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
public interface M2MGroupTimeteableDAO {
    void saveM2MGroupTimeteable(M2MGroupTimeteable m2mGroupTimeteable);
    List<M2MGroupTimeteable> listM2MGroupTimeteable();
    M2MGroupTimeteable getM2MGroupTimeteable(int id);
    M2MGroupTimeteable editM2MGroupTimeteable(M2MGroupTimeteable m2mGroupTimeteable);
    void deleteM2MGroupTimeteable(M2MGroupTimeteable m2mGroupTimeteable);
}
