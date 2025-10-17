package require4test.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import require4test.entities.User;

@RequestScoped
@Named("editUserBean")
public class EditUserBean {

    private User user;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    private boolean admin;
    private boolean requirementsEngineer;
    private boolean testcaseCreator;
    private boolean tester;
    private boolean testManager;

    public String editUser() {
        return "usermanagement.xhtml";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
