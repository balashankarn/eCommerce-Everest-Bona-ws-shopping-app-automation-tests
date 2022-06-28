package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.CheckoutPage;
import pom.wsi.LoginPage;

public class MSHAPP_866_Stepdefs {

    LoginPage login;
    Hooks hooks = new Hooks();
    AccountPage accountPage;
    AccountSettingPage accountSettingPage;
    CheckoutPage checkoutPage;

    @Then("user should been shown a NLA notification")
    public void userShouldBeenShownANLANotification() {

    }

    @Given("user is NLA notification screen")
    public void userIsNLANotificationScreen() {
    }
}
