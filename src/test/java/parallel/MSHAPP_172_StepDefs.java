package parallel;

import com.driverfactory.DriverManager;
import com.driverfactory.Factory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.LoginPage;

public class MSHAPP_172_StepDefs extends Factory {
    LoginPage login;
    Hooks hooks = new Hooks();
    AccountPage accountPage;
    AccountSettingPage accountSettingPage;

    @Given("user is in dashboard screen")
    public void userIsInDashBoardScreen(){
        accountPage = new AccountPage(DriverManager.getDriver());
        accountPage.userInDashBoardScreen();
    }


    @When("user is able should be able to view all the elements on dashboard")
    public void userIsAbleShouldBeAbleToViewAllTheElementsOnDashboard() {
        accountPage.verifyAllDashboardElements();

    }

    @Then("user should be able scroll up and down of the screen")
    public void userShouldBeAbleScrollUpAndDownOfTheScreen() {
        accountPage.scrollUp();
        accountPage.scrollDown();
    }

    @Given("user is on the account dashboard screen")
    public void userIsOnTheAccountDashboardScreen() {
        accountPage=new AccountPage(DriverManager.getDriver());
    }

    @When("user scrolls to bottom of the screen")
    public void userScrollsToBottomOfTheScreen() {
        accountPage.scrollUp();

    }

    @And("user clicks on account setting option")
    public void userClicksOnAccountSettingOption() {
        accountPage.navigateToAccountSettingPage();
    }

    @Then("user should be navigated to account setting screen.")
    public void userShouldBeNavigatedToAccountSettingScreen() {
        accountSettingPage.verifyScreenUI();


    }


}
