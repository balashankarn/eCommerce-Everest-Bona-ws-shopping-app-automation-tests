package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.LoginPage;

import java.sql.Driver;

public class MSHAPP_177_StepDefs {
    AccountPage accountPage = new AccountPage(DriverManager.getDriver());
    AccountSettingPage accountSettingPage = new AccountSettingPage(DriverManager.getDriver());

    @Given("user is in account dashboard")
    public void userIsInAccountDashBoard(){
        accountPage.userInDashBoardScreen();
    }

    @When("user launches apps and clicks on account setting")
    public void userLaunchesAppsAndClicksOnAccountSetting() {
        accountPage.navigateToAccountSettingPage();
    }

    @Then("user is in accoount setting screen")
    public void userIsInAccountSettingScreen() {
        accountSettingPage.viewChangeOption();
    }

    @Given("user lands on account setting page")
    public void userLandsOnAccountSettingPage() {
        accountSettingPage = new AccountSettingPage(DriverManager.getDriver());
    }

    @When("user clicks on change password")
    public void userClicksOnChangePassword() {
       accountSettingPage.navigateToChangePassword();
    }

    @Then("user lands on change password")
    public void userLandsOnChangePassword() {
   boolean status =  accountSettingPage.passwordScreenUI();
        Assert.assertTrue(status);
    }

    @Given("user is in change password screen")
    public void userIsInChangePasswordScreen() {
        accountSettingPage = new AccountSettingPage(DriverManager.getDriver());
    }

    @When("user clicks on the current password and new password")
    public void userClicksOnTheCurrentPasswordAndNewPassword() {
        accountSettingPage.userClickSOnCurrentPassword();
    }

    @Then("user enter {string} and {string}")
    public void userEnterAnd(String currentpassword, String newpassword) {
        accountSettingPage.userEnterCurrentPassword(currentpassword);
        accountSettingPage.userEnterNewPassword(newpassword);
    }

}
