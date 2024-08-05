package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    List<User> getUsers();

    void createUser(User user);

    User updateUser(int id, User user);

   void deleteUser(int id, User user);

    User getUser(int id);


}
