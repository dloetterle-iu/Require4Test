package require4test.services;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.NoResultException;
import require4test.entities.User;
import require4test.entities.User2UserRole;
import require4test.enums.UserRole;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named("usermanagementservice")
public class UserManagementService implements Serializable {

    @Serial
    private static final long serialVersionUID = 4757255153964318449L;

    private User currentUser = null;

    @Inject
    EntityManagementService entityManagementService;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User createUser(String username, String password, boolean admin) {
        System.out.println("Creating user " + username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        entityManagementService.persist(user);
        if (admin) {
            User2UserRole user2UserRole = new User2UserRole();
            user2UserRole.setUser(user);
            user2UserRole.setRole(UserRole.ADMIN);
            entityManagementService.persist(user2UserRole);
        }
        return user;
    }

    public boolean usersExist() {
        int count = EntityManagementService.getEntityManager().createQuery("SELECT COUNT(u) FROM User u", Long.class)
                .getSingleResult().intValue();
        System.out.printf("%d Nutzer vorhanden%n", count);
        return count > 0;
    }

    public User getUserByUsername(String username) {
        try {
            return (User) EntityManagementService.getEntityManager().createQuery("SELECT u FROM User u WHERE u.username = :username")
                    .setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<User> getUsers() {
        return EntityManagementService.getEntityManager().createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public List<User2UserRole> getUserRoles(User user) {
        return EntityManagementService.getEntityManager()
                .createQuery("SELECT r FROM User2UserRole r WHERE r.user = :user", User2UserRole.class)
                .setParameter("user", user)
                .getResultList();
    }

    public String getUserRolesString(User user) {
        List<User2UserRole> userRoles = getUserRoles(user);
        return userRoles.stream().map(r -> r.getRole().toString()).reduce("", (a, b) -> a.isEmpty() ? b : a + ", " + b);
    }
}
