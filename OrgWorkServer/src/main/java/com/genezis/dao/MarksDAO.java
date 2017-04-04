package com.genezis.dao;

import com.genezis.model.Marks;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface MarksDAO {
    public void saveMarks(Marks marks);
    public List<Marks> listMarks();
    public Marks getMarks(int id);
    public Marks editMarks(Marks marks);
}
