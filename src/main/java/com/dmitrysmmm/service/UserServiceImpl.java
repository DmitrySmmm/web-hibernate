package com.dmitrysmmm.service;

import com.dmitrysmmm.dao.UserDao;
import com.dmitrysmmm.model.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userdao) {
        this.userDao = userdao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void dropUser(long id) {
        userDao.dropUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(long id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void updateUser(User user, long id) {
        userDao.updateUser(user, id);
    }
}
