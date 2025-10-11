package require4test.services;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import require4test.entities.User;

import java.io.Serial;
import java.io.Serializable;

@SessionScoped
@Named("usermanagementservice")
public class UserManagementService implements Serializable {

    @Serial
    private static final long serialVersionUID = 4757255153964318449L;

    @Inject
    EntityManagementService entityManagementService;

    public User createUser(String username, String password) {
        System.out.println("Creating user " + username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        entityManagementService.persist(user);
        return user;
    }

    public boolean usersExist() {
        int count = EntityManagementService.getEntityManager().createQuery("SELECT COUNT(u) FROM User u", Long.class).getSingleResult().intValue();
        System.out.printf("%d Nutzer vorhanden%n", count);
        return count > 0;
    }

}
