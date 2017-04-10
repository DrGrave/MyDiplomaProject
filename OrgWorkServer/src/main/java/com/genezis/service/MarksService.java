package com.genezis.service;

import com.genezis.model.Marks;

/**
 * Created by vadim on 03.04.17.
 */
public interface MarksService {
    void saveMarks(Marks marks);
    Marks getMarks(int id);
    Marks editMarks(Marks marks);
    void deleteMarks(Marks marks);
    Marks ifExists(Marks marks);
}
