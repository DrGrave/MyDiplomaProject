package com.genezis.dao;

import com.genezis.model.Group;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface GroupDAO {
    void saveGroup(Group group);
    List<Group> list();
    Group getGroupById();
    Group editGroup(Group group);
    void deleteGroup(Group group);
}
