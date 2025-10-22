package require4test.services;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.NoResultException;
import require4test.entities.User;

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

    public void createUser(String username, String password, boolean admin, boolean requirementsEngineer,
                           boolean testManager, boolean testcaseCreator, boolean tester) {
        System.out.println("Creating user " + username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAdmin(admin);
        user.setRequirementsEngineer(requirementsEngineer);
        user.setTestcaseCreator(testcaseCreator);
        user.setTester(tester);
        user.setTestManager(testManager);
        entityManagementService.persist(user);
    }

    public boolean usersExist() {
        int count = EntityManagementService.getEntityManager().createQuery("SELECT COUNT(u) FROM User u", Long.class)
                .getSingleResult().intValue();
        System.out.printf("%d Nutzer vorhanden%n", count);
        return count > 0;
    }

    public User getUserByUsername(String username) {
        try {
            return (User) EntityManagementService.getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.username = :username").setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<User> getUsers() {
        return EntityManagementService.getEntityManager().createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    public void deleteUser(User user) {
        entityManagementService.remove(user);
    }
}
