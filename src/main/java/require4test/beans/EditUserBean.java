package require4test.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import require4test.entities.User;

import java.io.Serial;
import java.io.Serializable;

@SessionScoped
@Named("editUserBean")
public class EditUserBean implements Serializable {

    @Serial
    private static final long serialVersionUID = -4648137104288889592L;

    private User user;
    private boolean admin;
    private boolean requirementsEngineer;
    private boolean testcaseCreator;
    private boolean tester;
    private boolean testManager;

    public String editUser(User user) {
        System.out.println("Method called");
        this.user = user;
        this.admin = user.isAdmin();
        this.requirementsEngineer = user.isRequirementsEngineer();
        this.testcaseCreator = user.isTestcaseCreator();
        this.tester = user.isTester();
        this.testManager = user.isTestManager();
        return "edit_user.xhtml";
    }

    public String confirm() {
        System.out.println("Confirm called");
        user.setAdmin(admin);
        user.setRequirementsEngineer(requirementsEngineer);
        user.setTestcaseCreator(testcaseCreator);
        user.setTester(tester);
        user.setTestManager(testManager);
        return "usermanagement.xhtml";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isRequirementsEngineer() {
        return requirementsEngineer;
    }

    public void setRequirementsEngineer(boolean requirementsEngineer) {
        this.requirementsEngineer = requirementsEngineer;
    }

    public boolean isTestcaseCreator() {
        return testcaseCreator;
    }

    public void setTestcaseCreator(boolean testcaseCreator) {
        this.testcaseCreator = testcaseCreator;
    }

    public boolean isTester() {
        return tester;
    }

    public void setTester(boolean tester) {
        this.tester = tester;
    }

    public boolean isTestManager() {
        return testManager;
    }

    public void setTestManager(boolean testManager) {
        this.testManager = testManager;
    }
}
