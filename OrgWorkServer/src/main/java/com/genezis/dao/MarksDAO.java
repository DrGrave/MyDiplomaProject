package com.genezis.dao;

import com.genezis.model.Marks;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface MarksDAO {
    void saveMarks(Marks marks);
    List<Marks> listMarks();
    Marks getMarks(int id);
    Marks editMarks(Marks marks);
     void deleteMarks(Marks marks);
     Marks ifExistsMarks(Marks marks);
}
