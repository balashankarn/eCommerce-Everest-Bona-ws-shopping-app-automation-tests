package parallel;

import io.cucumber.java.en.Then;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.LoginPage;

public class MSHAPP_341_StepDefs {
    LoginPage login;
    Hooks hooks = new Hooks();
    AccountPage accountPage;
    AccountSettingPage accountSettingPage;


    @Then("user lands on dashboard screen and clicks on account setting")
    public void userLandsOnDashboardScreenAndClicksOnAccountSetting() {
      accountPage.accountDashBoard();
    }
}
