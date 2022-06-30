package parallel;

import com.driverfactory.DriverManager;
import com.driverfactory.Factory;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.CheckoutPage;
import pom.wsi.LoginPage;

public class MSHAPP_176_StepDef extends Factory {

    LoginPage login;
    Hooks hooks = new Hooks();
    AccountPage accountPage;
    AccountSettingPage accountSettingPage;

    @Given("user is on account dashboard screen")
    public void userIsOnAccountDashboardScreen() {
        accountPage = new AccountPage(DriverManager.getDriver());
        accountPage.accountDashBoard();
    }

    @And("user click on edit email option")
    public void userClickOnEditEmailOption() {
        accountSettingPage = new AccountSettingPage(DriverManager.getDriver());
        accountSettingPage.navigateToEditEmail();
    }

    @Then("user should be navigated to edit email screen")
    public void userShouldBeNavigatedToEditEmailScreen() {
        accountSettingPage.verifyEditEmailScreen();
    }

    @Given("user is in edit email screen")
    public void userIsInEditEmailScreen() {
        accountSettingPage = new AccountSettingPage(DriverManager.getDriver());
        accountSettingPage.verifyEditEmailScreen();
    }

    @When("user should  be able to tap on both feilds")
    public void userShouldBeAbleToTapOnBothFeilds() {
        accountSettingPage.userAbleToTapOnBothFeild();
    }

    @Then("UI should be as per the sketch")
    public void uiShouldBeAsPerTheSketch() {
        accountSettingPage.verifyEntireEditEmailUI();

    }


    @Then("user should be navigated back to account setting screen")
    public void userShouldBeNavigatedBackToAccountSettingScreen() {


    }

    @When("user navigate to account setting page")
    public void userNavigateToAccountSettingPage() {
        accountPage.navigateToAccountSettingPage();
    }

    @When("user enter currentpassword {string} and newemailaddress {string} clicks on close")
    public void userEnterCurrentpasswordAndNewemailaddressClicksOnClose(String currentpassword, String newemailaddress) throws InterruptedException {
        accountSettingPage.userEnterCurrentPassword(currentpassword);
        accountSettingPage.userEnterEmailAddress(newemailaddress);
        // accountSettingPage.userClicksOnCloseButton();

    }
}
