package app.dao;


import app.model.SmUsers;
import app.model.SmUsersFriends;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SmUsersFriendsDbRepository extends CrudRepository<SmUsersFriends, Integer> {

}
