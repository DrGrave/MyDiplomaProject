package com.sethomecompany.domain;

/**
 * Created by Vadim on 12.11.2016.
 */
public class UserCredential {
    private Integer idUserCredential;
    private String password;
    private String login;
    private Integer typeOfUser;
    private Integer user;

    public UserCredential(){};

    public UserCredential(Integer idUserCredential, String password, String login, Integer typeOfUser, Integer user) {
        this.idUserCredential = idUserCredential;
        this.password = password;
        this.login = login;
        this.typeOfUser = typeOfUser;
        this.user = user;
    }

    public Integer getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(Integer typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public Integer getIdUserCredential() {
        return idUserCredential;
    }

    public void setIdUserCredential(Integer idUserCredential) {
        this.idUserCredential = idUserCredential;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
}
