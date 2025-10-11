package require4test.beans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
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
        // TODO: Implement authentication logic
        return null; // or return a navigation outcome like "home?faces-redirect=true"
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
