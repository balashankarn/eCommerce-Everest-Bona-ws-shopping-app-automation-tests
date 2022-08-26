package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.CheckoutPage;
import pom.wsi.LoginPage;

public class MSHAPP_866_Stepdefs {


    @Then("user should been shown a NLA notification")
    public void userShouldBeenShownANLANotification() throws InterruptedException {


    }

    @Given("user is NLA notification screen")
    public void userIsNLANotificationScreen() throws InterruptedException {

        Assert.assertTrue(false);
    }

    @When("user clicks on NLA")
    public void userClicksOnNLA() {
    }

    @Then("user should be navigated back to cart")
    public void userShouldBeNavigatedBackToCart() {
    }
}
