package app.dao;

import app.model.User;

import java.util.Set;

public interface UserDbDao {

    Set<User> getFriendsList(Integer username);

    User getUserDetails(int userId);
}
