package com.sethomecompany.dao;

import com.sethomecompany.domain.Group;

/**
 * Created by Vadim on 11.12.2016.
 */
public interface GroupDAO {
    Integer addGroup(Group group);
    void deleteGroup(Group group);
    Group getGroup(Integer index);
}
