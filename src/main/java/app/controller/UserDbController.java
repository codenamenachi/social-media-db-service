package app.controller;

import app.model.User;
import app.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController("/db")
public class UserDbController {

    @Autowired
    private UserDbService userDbService;

    @GetMapping(value = "/v1/user/{userId}")
    public ResponseEntity<User> getUserDetails(@RequestParam String userId) {
        User userDetails = userDbService.getUserDetails(userId);
        if (userDetails != null) {
            return new ResponseEntity<>(userDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/v1/user/{userId}/friends")
    public ResponseEntity<Set<User>> getFriends(@RequestParam String userId) {
        Set<User> friendsList = userDbService.getFriendsList(userId);
        return new ResponseEntity<>(friendsList, HttpStatus.OK);
    }
}
