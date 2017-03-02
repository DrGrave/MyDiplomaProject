package com.sethomecompany.domain;

/**
 * Created by Vadim on 11.12.2016.
 */
public class Professor {
    Integer idProfessor;
    String ProfessorName;
    String ProfessorSurname;
    String ProfessorPatronum;

    public Professor(Integer idProfessor, String professorName, String professorSurname, String professorPatronum) {
        this.idProfessor = idProfessor;
        ProfessorName = professorName;
        ProfessorSurname = professorSurname;
        ProfessorPatronum = professorPatronum;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getProfessorName() {
        return ProfessorName;
    }

    public void setProfessorName(String professorName) {
        ProfessorName = professorName;
    }

    public String getProfessorSurname() {
        return ProfessorSurname;
    }

    public void setProfessorSurname(String professorSurname) {
        ProfessorSurname = professorSurname;
    }

    public String getProfessorPatronum() {
        return ProfessorPatronum;
    }

    public void setProfessorPatronum(String professorPatronum) {
        ProfessorPatronum = professorPatronum;
    }
}
