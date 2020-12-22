package app.service.impl;

import app.dao.UserDbDao;
import app.model.User;
import app.service.UserDbService;
import app.util.UserDbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserUserDbServiceImpl implements UserDbService {

    @Autowired
    private UserDbDao userDbDao;

    @Override
    public User getUserDetails(String userId) {
        UserDbUtil.validateRequest(userId);
        return userDbDao.getUserDetails(Integer.parseInt(userId));
    }

    public Set<User> getFriendsList(String userId) {

        UserDbUtil.validateRequest(userId);
        return userDbDao.getFriendsList(Integer.parseInt(userId));
    }
}
