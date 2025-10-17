package require4test.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named("addUserBean")
public class AddUserBean {

    private String username;
    private String password;
    private String confirmPassword;
    private boolean admin;
    private boolean requirementsEngineer;
    private boolean testcaseCreator;
    private boolean tester;
    private boolean testManager;

    public String createUser() {
        System.out.println("created ;)");
        System.out.println(username);
        System.out.println(password);
        System.out.println(confirmPassword);
        System.out.println(admin);
        System.out.println(requirementsEngineer);
        System.out.println(testcaseCreator);
        System.out.println(tester);
        System.out.println(testManager);
        return "usermanagement.xhtml";
    }

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
