package users;

public class SessionUser {
    public static User user;

    public static void setSessionUser(User userSession) {
        user = userSession;
    }
}
