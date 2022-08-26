package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.wsi.AccountPage;
import pom.wsi.AccountSettingPage;
import pom.wsi.CheckoutPage;
import pom.wsi.LoginPage;

public class MSHAPP_867_StepDefs {

    AccountPage accountPage = new AccountPage(DriverManager.getDriver());
    CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver());

    @Given("user is account dashboard screen")
    public void userIsAccountDashBoardScree(){
        accountPage.userInDashBoardScreen();

    }

    @When("user clicks on cart option in tab bar")
    public void userClicksOnCartOptionInTabBar() {
        checkoutPage.userClickOnCart();
    }

    @Then("once user is cart screen user should be able to view checkout button")
    public void onceUserIsCartScreenUserShouldBeAbleToViewCheckoutButton() throws InterruptedException {
        checkoutPage.userClickOnCheckOutInCartPage();
    }

    @Given("user is in checkout screen")
    public void userIsInCheckoutScreen() throws InterruptedException {
        //checkoutPage
    }

    @When("user click checkout  in payment screen")
    public void userClickCheckoutInPaymentScreen() throws InterruptedException {

    }

    @Then("user should been shown a BO notification")
    public void userShouldBeenShownABONotification() throws InterruptedException {


    }

    @Given("user is BO notification screen")
    public void userIsBONotificationScreen() throws InterruptedException {


    }

    @When("user clicks on BO")
    public void userClicksOnBO() throws InterruptedException {

    }

    @Then("user should be navigated back to cart in")
    public void userShouldBeNavigatedBackToCartIn() throws InterruptedException {

    }

    @Then("user should been shown a shipping restriction notification")
    public void userShouldBeenShownAShippingRestrictionNotification() throws InterruptedException {

    }
}
