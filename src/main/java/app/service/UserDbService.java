package app.service;

import app.model.User;

import java.util.Set;

public interface UserDbService {


    Set<User> getFriendsList(String username);

    User getUserDetails(String userId);
}
