package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pom.wsi.*;

public class MSHAPP_1028_Stepdefs {

    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());

    @And("user clicks on privacy setting and selects privacy")
    public void userClicksOnPrivacySettingAndSelectsPrivacy() {
        registryPage.userClicksOnPrivacySettingAndSelectsPrivacy();
    }

    @Then("the selected privacy type should be populated")
    public void theSelectedPrivacyTypeShouldBePopulated() {
        registryPage.theSelectedPrivacyTypeShouldBePopulated();
        registryPage.quitBrowser();

    }
}
