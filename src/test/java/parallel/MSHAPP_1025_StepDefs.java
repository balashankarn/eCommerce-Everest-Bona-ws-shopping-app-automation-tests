package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.wsi.*;

public class MSHAPP_1025_StepDefs {

    LoginPage login;
    Hooks hooks = new Hooks();
    AccountPage accountPage;
    AccountSettingPage accountSettingPage;
    RegistryPage registryPage;
    PermissionPage permissionPage;


    @Given("user launches the apps")
    public void userLaunchesTheApp() {
        hooks.launchBrowser();
        registryPage = new RegistryPage(DriverManager.getDriver());
        permissionPage = new PermissionPage(DriverManager.getDriver());
        login =new LoginPage(DriverManager.getDriver());
        permissionPage.clickOnAllowOnce();
    }

    @When("user click on registry in bottom navigation bar")
    public void userClickOnRegistryInBottomNavigationBar() {
        registryPage.userClickOnRegistry();

    }

    @Then("user lands on registry screen")
    public void userLandsOnRegistryScreen() {
        registryPage.userLandsOnRegistry();

    }

    @Given("user is on registry screen")
    public void userIsOnRegistryScreen() {
        registryPage = new RegistryPage(DriverManager.getDriver());
        registryPage.userInRegistryScreen();
    }

    @When("user clicks on create registry")
    public void userClicksOnCreateRegistry() {
        registryPage.userClickOnFindRegistry();
    }

    @Then("user lands on sign in screen")
    public void userLandsOnSignInScreen() {
        registryPage.userLandsOnSignIn();
    }

    @Given("user is on sign screen")
    public void userIsOnSignScreen() {
        registryPage = new RegistryPage(DriverManager.getDriver());
       registryPage.userIsOnSignIn();

    }

    @Then("user should land on create registry screen one")
    public void userShouldLandOnCreateRegistryScreenOne() {
 registryPage.userShouldLandOnCreateRegistryScreenOne();
    }

    @And("user enter username {string} and password {string} clicks on login in sign in page")
    public void userEnterUsernameAndPasswordClicksOnLoginInSignInPage(String username, String password) {
        registryPage.userEnterUserName(username);
        registryPage.userEnterPassword(password);
        registryPage.clickLoginBth();
    }
}
