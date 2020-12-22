package app.dao.impl;

import app.dao.SmUsersDbRepository;
import app.dao.SmUsersFriendsDbRepository;
import app.dao.UserDbDao;
import app.model.SmUsers;
import app.model.SmUsersFriends;
import app.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserDbDaoImpl implements UserDbDao {

    @Autowired
    private SmUsersDbRepository usersDbRepository;

    @Autowired
    private SmUsersFriendsDbRepository friendsDbRepository;

    @Override
    public User getUserDetails(int userId) {

        Optional<SmUsers> userEntityDetails = usersDbRepository.findById(userId);

        User userDetails = null;
        if(userEntityDetails.isPresent()){
            userDetails = new User();
            BeanUtils.copyProperties(userEntityDetails, userDetails);
        }
        return userDetails;
    }

    @Override
    public Set<User> getFriendsList(Integer userId) {

        Optional<SmUsersFriends> usersFriendsData = friendsDbRepository.findById(userId);

        Set<User> friendsList = new HashSet<>();
        if (usersFriendsData.isPresent()) {
            Set<SmUsers> friendsSet = usersFriendsData.get().getUsers();

            friendsSet.forEach(user -> {
                User friend = new User();
                BeanUtils.copyProperties(user, friend);
                friendsList.add(friend);
            });
        }

        return friendsList;
    }
}
