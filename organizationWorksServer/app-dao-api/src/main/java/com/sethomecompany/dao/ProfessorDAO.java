package com.sethomecompany.dao;

import com.sethomecompany.domain.Professor;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public interface ProfessorDAO {
    List<Professor> getAllProfessor();

    Professor getProfessorById(Integer userId);

    Integer addProfessor(Professor professor);

    void updateProfessor(Professor professor);

    void deleteProfessor(Professor professor);

    void deleteProfessorById(Integer id);
}
