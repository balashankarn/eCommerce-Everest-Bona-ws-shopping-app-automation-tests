package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pom.wsi.*;

public class MSHAPP_1027_Stepdefs {
    LoginPage login;
    Hooks hooks = new Hooks();
    AccountPage accountPage;
    AccountSettingPage accountSettingPage;
    RegistryPage registryPage;
    PermissionPage permissionPage;

  @And("user clicks on event type and selects event date")
      public void userClicksOnEvenTypeAndSelectsEventDate(){
      registryPage = new RegistryPage(DriverManager.getDriver());
           registryPage.userClicksOnEvenTypeAndSelectsEventDate();

      }

    @Then("the selected event date should be populated here")
    public void theSelectedEventDateShouldBePopulatedHere() {
       registryPage.theSelectDateAndEventShouldBeDisplayedthere();
       registryPage.quitBrowser();
    }
}
