package web.CrudBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.CrudBoot.dao.UserDao;
import web.CrudBoot.dao.UserDaoImpl;
import web.CrudBoot.model.User;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public void updateUser(Long id, User updatedUser) {
        userDao.updateUser(id, updatedUser);
    }
}