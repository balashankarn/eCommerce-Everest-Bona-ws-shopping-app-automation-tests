package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.CheckoutPage;
import pom.wsi.LoginPage;

public class MSHAPP_874_StepDefs {
    LoginPage login;
    Hooks hooks = new Hooks();
    AccountPage accountPage;
    AccountSettingPage accountSettingPage;
    CheckoutPage checkoutPage;

    @Given("user is shipping notification screen")
    public void userIsShippingNotificationScreen() {
    }

    @When("user clicks on ship restriction")
    public void userClicksOnShipRestriction() {

    }
}
