package com.sethomecompany.dao;

import com.sethomecompany.domain.Marks;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public interface MarksDAO {
    List<Marks> getAllMarks(Integer userID);

    Marks getMarkById(Integer markId);

    Integer addMark(Marks marks);

    void updateMark(Marks marks);

    void deleteMark(Marks marks);

}
