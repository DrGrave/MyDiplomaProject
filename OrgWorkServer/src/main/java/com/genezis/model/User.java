package com.genezis.model;

import javax.persistence.*;


@Entity
@Table(name="myUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdUser;


    @Column(name = "UserName", nullable = false)
    private String userName;

    @Column(name = "UserSurname", nullable = false)
    private String userSurname;

    @Column(name = "UserSeccondname", nullable = false)
    private String userSeccondname;


    @ManyToOne
    @JoinColumn(name = "IdGroup")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "IdUserType")
    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public User() {
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserSeccondname() {
        return userSeccondname;
    }

    public void setUserSeccondname(String userSeccondname) {
        this.userSeccondname = userSeccondname;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
