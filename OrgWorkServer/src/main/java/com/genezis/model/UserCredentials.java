package com.genezis.model;

import javax.persistence.*;

/**
 * Created by vadim on 03.04.17.
 */
@Entity
@Table(name = "UserCredential")
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserCredential;

    @Column(name = "UserLogin")
    private String userLogin;

    @Column(name = "UserPassword")
    private String userPassword;

    @OneToOne
    @JoinColumn(name = "IdUser")
    private myUser myUser;

    public int getIdUserCredential() {
        return idUserCredential;
    }

    public void setIdUserCredential(int idUserCredential) {
        this.idUserCredential = idUserCredential;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public myUser getMyUser() {
        return myUser;
    }

    public void setMyUser(myUser myUser) {
        this.myUser = myUser;
    }

    @Override
    public String toString() {
        return "UserCredentials{" +
                "idUserCredential=" + idUserCredential +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", myUser=" + myUser +
                '}';
    }
}
