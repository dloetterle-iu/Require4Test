package require4test.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import require4test.services.UserManagementService;

import java.io.Serializable;

@SessionScoped
@Named("addUserBean")
public class AddUserBean implements Serializable {

    private static final long serialVersionUID = 1750233314497527366L;

    @Inject
    UserManagementService userManagementService;

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
        userManagementService.createUser(username, password, admin, requirementsEngineer, testcaseCreator, tester,
                testManager);
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

    public void checkPassword(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (!password.equals(confirmPassword)) {
            throw new ValidatorException(new FacesMessage("Passwörter stimmen nicht überein!"));
        }
    }

    public boolean passwordsMatchNotEmpty() {
        return password != null && !password.isEmpty() && confirmPassword != null && !confirmPassword.isEmpty()
                && password.equals(confirmPassword);
    }
}
