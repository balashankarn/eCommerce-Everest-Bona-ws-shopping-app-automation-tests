package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pom.wsi.*;

public class MSHAPP_1028_Stepdefs {
    LoginPage login;
    Hooks hooks = new Hooks();
    AccountPage accountPage;
    AccountSettingPage accountSettingPage;
    RegistryPage registryPage;
    PermissionPage permissionPage;
    @And("user clicks on privacy setting and selects privacy")
    public void userClicksOnPrivacySettingAndSelectsPrivacy() {
        registryPage = new RegistryPage(DriverManager.getDriver());
        registryPage.userClicksOnPrivacySettingAndSelectsPrivacy();
    }

    @Then("the selected privacy type should be populated")
    public void theSelectedPrivacyTypeShouldBePopulated() {
        registryPage.theSelectedPrivacyTypeShouldBePopulated();
        registryPage.quitBrowser();

    }
}
