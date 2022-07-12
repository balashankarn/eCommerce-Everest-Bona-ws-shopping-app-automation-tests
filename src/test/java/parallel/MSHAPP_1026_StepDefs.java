package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pom.wsi.*;

public class MSHAPP_1026_StepDefs {

    LoginPage login;
    Hooks hooks = new Hooks();
    AccountPage accountPage;
    AccountSettingPage accountSettingPage;
    RegistryPage registryPage;
    PermissionPage permissionPage;


    @Given("user  is on create event screen")
    public void userIsOnCreateEventScreen() {
        registryPage = new RegistryPage(DriverManager.getDriver());
        registryPage.userShouldLandOnCreateRegistryScreenOne();

    }

    @And("user clicks on event type and selects event")
    public void userClicksOnEventTypeAndSelectsEvent() {
        registryPage.selectEvenType();
    }

    @Then("the selected event should be populated here")
    public void theSelectedEventShouldBePopulatedHere() {
        registryPage.selectedEventTypeShouldBePopulated();
        registryPage.quitBrowser();
    }
}
