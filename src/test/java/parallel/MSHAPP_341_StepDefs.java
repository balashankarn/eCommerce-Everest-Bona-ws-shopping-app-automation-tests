package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Then;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.LoginPage;

public class MSHAPP_341_StepDefs {

    AccountPage accountPage = new AccountPage(DriverManager.getDriver());

    @Then("user lands on dashboard screen and clicks on account setting")
    public void userLandsOnDashboardScreenAndClicksOnAccountSetting() {
      accountPage.accountDashBoard();
    }
}
