package web.CrudBoot.dao;


import web.CrudBoot.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();


    public User getUserById(Long id);


    public void saveUser(User user);


    public void updateUser(Long id, User updateUser);

    public void deleteUser(Long id);
}
