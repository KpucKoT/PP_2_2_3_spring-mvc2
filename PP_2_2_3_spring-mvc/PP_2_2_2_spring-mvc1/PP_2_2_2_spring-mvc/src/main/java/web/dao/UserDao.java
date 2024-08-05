package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User getUser(int id);
}
