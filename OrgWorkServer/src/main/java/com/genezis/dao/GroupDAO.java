package com.genezis.dao;

import com.genezis.model.Group;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface GroupDAO {
    public void saveGroup(Group group);
    public List<Group> list();
    public Group getGroupById();
    public  Group editGroup(Group group);
}
