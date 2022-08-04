package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pom.wsi.*;

public class MSHAPP_1028_Stepdefs {

    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());

    @Given("user select the Privacy setting as {string}")
    public void user_select_the_privacy_setting_as(String privacyType) {
        registryPage.clickOnPrivacySettingAndSelectsPrivacy();
    }

    @Then("user should able to see the selected value {string} in Privacy Settings")
    public void user_should_able_to_see_the_selected_value_in_privacy_settings(String expPrivacyType) {
      String actualPrivacyType =  registryPage.verifyPrivacyTYpeGetsDisplayed();
        Assert.assertEquals(actualPrivacyType,expPrivacyType);

    }
}
