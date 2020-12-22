package app.dao;


import app.model.SmUsers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SmUsersDbRepository extends CrudRepository<SmUsers, Integer> {

    List<SmUsers> findByUserId(String userId);
}
