package require4test.beans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import require4test.entities.User;
import require4test.services.UserManagementService;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("userManagementBean")
@SessionScoped
public class UserManagementBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 7284134419376087069L;

    @Inject
    UserManagementService userManagementService;

    private List<User> users = new ArrayList<>();

    private User userToEdit;

    @PostConstruct
    public void init() {
        users = userManagementService.getUsers();
    }

    public String editUser(User user) {
        this.userToEdit = user;
        return "edit_user.xhtml";
    }

    public String addUser() {
        return "add_user.xhtml";
    }

    public String getUserRoles(User user) {
        return userManagementService.getUserRolesString(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserToEdit() {
        return userToEdit;
    }

    public void setUserToEdit(User userToEdit) {
        this.userToEdit = userToEdit;
    }
}
