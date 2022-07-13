package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Then;
import pom.wsi.*;

public class MSHAPP_1032_Stepdef {
    LoginPage login;
    Hooks hooks = new Hooks();
    AccountPage accountPage;
    AccountSettingPage accountSettingPage;
    RegistryPage registryPage;
    PermissionPage permissionPage;
    @Then("user clicks on next step")
    public void userClicksOnNextStep() {
        registryPage = new RegistryPage(DriverManager.getDriver());
        registryPage.userClicksOnNextButton();
    }
}
