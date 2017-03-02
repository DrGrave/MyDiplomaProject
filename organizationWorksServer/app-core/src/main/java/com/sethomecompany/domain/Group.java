package com.sethomecompany.domain;

/**
 * Created by Vadim on 11.12.2016.
 */
public class Group {
    private Integer idGroup;
    private String numberOfGroup;
    private Integer studentStarosta;


    public Group(Integer idGroup, String numberOfGroup, Integer studentStarosta) {
        this.idGroup = idGroup;
        this.numberOfGroup = numberOfGroup;
        this.studentStarosta = studentStarosta;
    }

    public Group() {
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(String numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public Integer getStudentStarosta() {
        return studentStarosta;
    }

    public void setStudentStarosta(Integer studentStarosta) {
        this.studentStarosta = studentStarosta;
    }
}
