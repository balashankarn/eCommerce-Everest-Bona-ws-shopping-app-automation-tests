package parallel;

import com.driverfactory.DriverManager;
import com.driverfactory.Factory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pom.wsi.CheckoutPage;
import pom.wsi.LoginPage;

public class MSHAPP_346_StepDef extends Factory {

    CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver());


    @And("user clicks on cart")
    public void userClicksOnCart() {
        checkoutPage.userClickOnCart();
    }

    @Then("user lands on checkout")
    public void userLandsOnCheckout() {
        checkoutPage.userLandsOnCheckout();
    }

    @Given("user is on the cart page")
    public void userIsOnTheCartPage() {

    }

    @Given("user is on the checkout page")
    public void userIsOnTheCheckoutPage() {
        checkoutPage.userIsOnCheckoutPage();
    }
    @And("user clicks on checkout button")
    public void userClicksOnCheckoutButton() {
        checkoutPage.userClickOnCheckOut();
    }
    @Then("user should land on login page")
    public void userShouldLandOnLoginPage() {
        checkoutPage.userLandsonSignInPage();
    }
    @Given("user is on login page")
    public void userIsOnLoginPage() {
        checkoutPage.userIsOnSignInPage();
    }
    @And("user clicks on cross button")
    public void userClicksOnCrossButton() {
        checkoutPage.userClicksOnClosebtn();
    }

    @Then("user should land on cart page")
    public void userShouldLandOnCartPage() {
        checkoutPage.userLandsOnCartPage();
    }

}
