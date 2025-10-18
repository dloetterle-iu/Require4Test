package require4test.beans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.mindrot.jbcrypt.BCrypt;
import require4test.entities.User;
import require4test.services.UserManagementService;

@Named("loginBean")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;

    private boolean userExist;

    @Inject
    UserManagementService userManagementService;

    @PostConstruct
    public void init() {
        userExist = userManagementService.usersExist();
    }

    public String login() {
        System.out.println("Login attempt for user: " + username);
        if (!userExist) {
            userManagementService.createUser(username, password, true, false, false, false, false);
            System.out.printf("AdminUser created ('%s')%n", username);
            return "login.xhtml";
        }
        User userByUsername = userManagementService.getUserByUsername(username);
        if (userByUsername == null) {
            System.out.println("Unknown user");
            return "login.xhtml";
        }
        if (BCrypt.checkpw(password, userByUsername.getPassword())) {
            System.out.println("User logged in");
            userManagementService.setCurrentUser(userByUsername);
            return "index.xhtml";
        }
        System.out.println("Wrong password");
        return "login.xhtml";
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getUserExists() {
        return userExist;
    }
}
