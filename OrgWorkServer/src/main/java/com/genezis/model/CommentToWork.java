package com.genezis.model;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name = "CommentToWork")
public class CommentToWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommentToWork;

    @Column(name = "TextOfCommentWork")
    private String textOfCommentWork;

    @OneToOne
    @JoinColumn(name = "IdUserProfessor")
    private myUser professor;

    @OneToOne
    @JoinColumn(name = "IdUserStudent")
    private myUser student;

    @OneToOne
    @JoinColumn(name = "IdOfWork")
    private Work work;

    public int getIdCommentToWork() {
        return idCommentToWork;
    }

    public void setIdCommentToWork(int idCommentToWork) {
        this.idCommentToWork = idCommentToWork;
    }

    public String getTextOfCommentWork() {
        return textOfCommentWork;
    }

    public void setTextOfCommentWork(String textOfCommentWork) {
        this.textOfCommentWork = textOfCommentWork;
    }

    public myUser getProfessor() {
        return professor;
    }

    public void setProfessor(myUser professor) {
        this.professor = professor;
    }

    public myUser getStudent() {
        return student;
    }

    public void setStudent(myUser student) {
        this.student = student;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "CommentToWork{" +
                "idCommentToWork=" + idCommentToWork +
                ", textOfCommentWork='" + textOfCommentWork + '\'' +
                ", professor=" + professor +
                ", student=" + student +
                ", work=" + work +
                '}';
    }
}
