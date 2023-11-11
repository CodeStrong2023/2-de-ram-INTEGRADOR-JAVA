package auth;

import users.User;

public class SessionUser {
    // Atributo estático para almacenar el usuario de la sesión
    public static User user;

    // Método estático para establecer el usuario de la sesión
    public static void setSessionUser(User userSession) {
        user = userSession;
    }
}
