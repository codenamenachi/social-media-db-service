package app.util;

public class UserDbUtil {

    public static void validateRequest(String username) throws IllegalArgumentException {
        if(username == null || username.equalsIgnoreCase(""))
            throw new IllegalArgumentException("Invalid Username");
    }
}
