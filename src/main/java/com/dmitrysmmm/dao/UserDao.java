package com.dmitrysmmm.dao;

import com.dmitrysmmm.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void dropUser(long id);

    List<User> getAll();

    User show(long id);

    void updateUser(User user);



}
