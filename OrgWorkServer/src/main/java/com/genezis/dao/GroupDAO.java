package com.genezis.dao;

import com.genezis.model.StudentGroup;

import java.util.List;


public interface GroupDAO {
    void saveGroup(StudentGroup studentGroup);
    List<StudentGroup> list();
    StudentGroup getGroupById(int id);
    StudentGroup editGroup(StudentGroup studentGroup);
    void deleteGroup(StudentGroup studentGroup);
}
