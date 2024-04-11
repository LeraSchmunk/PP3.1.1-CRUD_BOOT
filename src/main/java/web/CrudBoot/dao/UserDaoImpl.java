package web.CrudBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.CrudBoot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", (User.class)).getResultList();
    }


    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }


    public void saveUser(User user) {
        entityManager.persist(user);
    }


    public void updateUser(Long id, User updateUser) {
        User upUser = getUserById(id);
        upUser.setName(updateUser.getName());
        upUser.setSurname(updateUser.getSurname());
        upUser.setAge(updateUser.getAge());
        entityManager.merge(upUser);
    }


    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User user where user.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}