package com.genezis.model;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name = "CommentToStudent")
public class CommentToStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommentOfStudent;

    @Column(name = "TextOfComment")
    private String textOfComment;

    @OneToOne
    @JoinColumn(name = "IdUserProfessor")
    private User professor;

    @OneToOne
    @JoinColumn(name = "IdUserStudent")
    private User student;

    public int getIdCommentOfStudent() {
        return idCommentOfStudent;
    }

    public void setIdCommentOfStudent(int idCommentOfStudent) {
        this.idCommentOfStudent = idCommentOfStudent;
    }

    public String getTextOfComment() {
        return textOfComment;
    }

    public void setTextOfComment(String textOfComment) {
        this.textOfComment = textOfComment;
    }

    public User getProfessor() {
        return professor;
    }

    public void setProfessor(User professor) {
        this.professor = professor;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "CommentToStudent{" +
                "idCommentOfStudent=" + idCommentOfStudent +
                ", textOfComment='" + textOfComment + '\'' +
                ", professor=" + professor +
                ", student=" + student +
                '}';
    }
}