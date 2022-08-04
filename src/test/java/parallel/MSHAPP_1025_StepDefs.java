package parallel;

import com.driverfactory.DriverManager;
import com.driverfactory.Factory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pom.wsi.*;

public class MSHAPP_1025_StepDefs extends Factory {
    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());
    PermissionPage permissionPage = new PermissionPage(DriverManager.getDriver());


    @Given("User continue shopping as guest user")
    public void UserContinueShoppingAsGuestUser() {
        permissionPage.continueShopping();
    }

    @When("user click on registry in bottom navigation bar")
    public void userClickOnRegistryInBottomNavigationBar() {
        registryPage.userClickOnRegistry();
    }

    @Then("user lands on registry screen")
    public void userLandsOnRegistryScreen() {
     boolean status =  registryPage.userLandsOnRegistry();
     Assert.assertTrue(status);
    }

    @Given("user is on registry screen")
    public void userIsOnRegistryScreen() {
      boolean status =  registryPage.userInRegistryScreen();
      Assert.assertTrue(status);
    }
    @When("user clicks on create registry")
    public void userClicksOnCreateRegistry()
    {
        registryPage.userClickOnCreateRegistry();
    }
    @Then("user lands on sign in screen")
    public void userLandsOnSignInScreen()
    {
        registryPage.userLandsOnSignIn();
    }
    @Given("user is on sign screen")
    public void userIsOnSignScreen() {
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
    @And("user quits the screen")
    public void userQuitsTheScreen()
    {
     registryPage.quitBrowser();
    }
    @Then("user navigate to back page")
    public void user_navigate_to_back_page() {
        registryPage.navigateToBackPage();
    }
    @Then("user sign out the application")
    public void user_sign_out_the_application() {
        registryPage.signOut();
    }
    @When("Sign out the app if already signed in")
    public void sign_out_the_app_if_already_signed_in() {
        registryPage.signOutIfAlreadySignedIn();
    }
}
