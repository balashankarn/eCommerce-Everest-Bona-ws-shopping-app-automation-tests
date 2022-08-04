package parallel;

import com.driverfactory.DriverManager;
import com.driverfactory.Factory;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.CheckoutPage;
import pom.wsi.LoginPage;

public class MSHAPP_176_StepDef extends Factory {

    AccountPage accountPage =  new AccountPage(DriverManager.getDriver());
    AccountSettingPage accountSettingPage = new AccountSettingPage(DriverManager.getDriver());

    @Given("user is on account dashboard screen")
    public void userIsOnAccountDashboardScreen() {
        accountPage.accountDashBoard();
    }

    @And("user click on edit email option")
    public void userClickOnEditEmailOption() {

        accountSettingPage.navigateToEditEmail();
    }

    @Then("user should be navigated to edit email screen")
    public void userShouldBeNavigatedToEditEmailScreen() {
        accountSettingPage.verifyEditEmailScreen();
    }

    @Given("user is in edit email screen")
    public void userIsInEditEmailScreen() {

        accountSettingPage.verifyEditEmailScreen();
    }

    @When("user should  be able to tap on both fields")
    public void userShouldBeAbleToTapOnBothFields() {
        accountSettingPage.userAbleToTapOnBothFeild();
    }

    @Then("UI should be as per the sketch")
    public void uiShouldBeAsPerTheSketch() {
     boolean status =   accountSettingPage.verifyEntireEditEmailUI();
     Assert.assertTrue(status);

    }

    @Then("user should be navigated back to account setting screen")
    public void userShouldBeNavigatedBackToAccountSettingScreen() throws InterruptedException {
      boolean status =  accountSettingPage.userClicksOnCloseButton();
      Assert.assertTrue(status);
    }
    @When("user navigate to account setting page")
    public void userNavigateToAccountSettingPage() {
        accountPage.navigateToAccountSettingPage();
    }

    @When("user enter currentpassword {string} and newemailaddress {string} clicks on close")
    public void userEnterCurrentpasswordAndNewemailaddressClicksOnClose(String currentpassword, String newemailaddress) throws InterruptedException {
        accountSettingPage.userEnterCurrentPassword(currentpassword);
        accountSettingPage.userEnterEmailAddress(newemailaddress);
    }
}
