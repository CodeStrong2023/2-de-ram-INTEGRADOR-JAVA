package auth;

import users.User;

public class SessionUser {
    public static User user;

    public static void setSessionUser(User userSession) {
        user = userSession;
    }
}
