package parallel;

import com.driverfactory.DriverManager;
import com.driverfactory.Factory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.LoginPage;

public class MSHAPP_172_StepDefs extends Factory {
    AccountPage accountPage = new AccountPage(DriverManager.getDriver());
    AccountSettingPage accountSettingPage = new AccountSettingPage((DriverManager.getDriver()));

    @Given("user is in dashboard screen")
    public void userIsInDashBoardScreen() {
        accountPage.userInDashBoardScreen();
    }


    @When("user is able should be able to view all the elements on dashboard")
    public void userIsAbleShouldBeAbleToViewAllTheElementsOnDashboard() {
        boolean status = accountPage.verifyAllDashboardElements();
        Assert.assertTrue(status);
    }

    @Then("user should be able scroll up and down of the screen")
    public void userShouldBeAbleScrollUpAndDownOfTheScreen() {
        accountPage.scrollUp();
        accountPage.scrollDown();
    }

    @Given("user is on the account dashboard screen")
    public void userIsOnTheAccountDashboardScreen() {
        accountPage = new AccountPage(DriverManager.getDriver());
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
        boolean status = accountSettingPage.verifyScreenUI();
        Assert.assertTrue(status);
    }

    @Given("user is dashboard screen")
    public void userIsDashboardScreen() {
        accountPage.accountDashBoard();
    }

    @Then("User should be in homepage")
    public void user_should_be_in_homepage() {
        boolean status = accountPage.verifyHomePageGetsDisplayed();
        Assert.assertTrue(status);
    }

    @Then("User should be in Account page")
    public void user_should_be_in_account_page() {
        boolean status = accountPage.verifyAccountPageGetDisplayed();
        Assert.assertTrue(status);
    }


}
