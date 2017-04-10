package com.genezis.service;

import com.genezis.model.MyUser;

/**
 * Created by vadim on 03.04.17.
 */
public interface UserService {
    void saveMyUser(MyUser myUser);
    MyUser getMyUserById(int id);
    MyUser editMyUser(MyUser myUser);
    void deleteMyUser(MyUser myUser);
    MyUser ifExists(MyUser myUser);
}
