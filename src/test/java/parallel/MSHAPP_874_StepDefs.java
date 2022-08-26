package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.CheckoutPage;
import pom.wsi.LoginPage;

public class MSHAPP_874_StepDefs {

    @Given("user is shipping notification screen")
    public void userIsShippingNotificationScreen() throws InterruptedException {

        wait(2000);
    }

    @When("user clicks on ship restriction")
    public void userClicksOnShipRestriction() throws InterruptedException {

        wait(2000);
    }
}
