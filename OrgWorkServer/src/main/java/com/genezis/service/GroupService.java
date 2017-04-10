package com.genezis.service;

import com.genezis.model.StudentGroup;

/**
 * Created by vadim on 03.04.17.
 */
public interface GroupService {
    void saveStudentGroup(StudentGroup studentGroup);
    StudentGroup getStudentGroup(int id);
    StudentGroup editStudentGroup(StudentGroup studentGroup);
    void deleteStudentGroup(StudentGroup studentGroup);
    StudentGroup ifExists(StudentGroup studentGroup);
}
