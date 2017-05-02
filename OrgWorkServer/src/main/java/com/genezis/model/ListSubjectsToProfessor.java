package com.genezis.model;

import java.util.List;

/**
 * Created by vadim on 02.05.17.
 */
public class ListSubjectsToProfessor {
    private MyUser myUser;
    private List<Subject> subjects;

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
