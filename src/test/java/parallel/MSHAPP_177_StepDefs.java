package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.LoginPage;

public class MSHAPP_177_StepDefs {
    LoginPage login;
    Hooks hooks = new Hooks();
    AccountPage accountPage;
    AccountSettingPage accountSettingPage;

    @Given("user is in account dashboard")
    public void userIsInAccountDashBoard(){
        accountPage= new AccountPage(DriverManager.getDriver());
        accountPage.userInDashBoardScreen();

    }

    @When("user launches apps and clicks on account setting")
    public void userLaunchesAppsAndClicksOnAccountSetting() {
        accountPage.navigateToAccountSettingPage();
    }

    @Then("user is in accoount setting screen")
    public void userIsInAccoountSettingScreen() {
       accountSettingPage =new AccountSettingPage(DriverManager.getDriver());
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
accountSettingPage.passwordScreenUI();
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

        accountSettingPage.userEnterNewPassword(newpassword);
        accountSettingPage.userEnterCurrentPassword(currentpassword);
       accountSettingPage.quitBrowser();
    }
}
