package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pom.wsi.*;

public class MSHAPP_1032_Stepdef {
    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());
    PermissionPage permissionPage = new PermissionPage(DriverManager.getDriver());

    @Then("user clicks on next step")
    public void userClicksOnNextStep() {
        registryPage.userClicksOnNextButton();
    }

    @Given("user is step three screen")
    public void userIsStepThreeScreen() {
        registryPage.userIsStepThreeScreen();
    }

    @And("user clicks on next button")
    public void userClicksOnNextButton() {
        registryPage.userClicksOnNextButton();
    }

    @And("user cliks on continue shopping")
    public void userCliksOnContinueShopping() {
        registryPage.startShopping();
    }

    @When("user select to sign in")
    public void userSelectToSignIn() {
        permissionPage.continueShopping();
    }

    @Then("user clicks on continue shopping")
    public void userClicksOnContinueShopping() {
        registryPage.startShopping();
    }

    @Given("user navigates to registry screen")
    public void userNavigatesToRegistryScreen() {
        registryPage.userClickOnRegistry();
    }

    @When("user scrolls to the bottom of the page")
    public void userScrollsToTheBottomOfThePage() {
        registryPage.userScrollToBottom();
    }

    @Then("user clicks on create registry in the bottom of the screen")
    public void userClicksOnCreateRegistryInTheBottomOfTheScreen() {
        registryPage.userClickOnCreateRegistry();
    }

    @Then("user clicks on Next button")
    public void user_clicks_on_next_button() {
        registryPage.clickOnNextButton();
    }

    @Given("user enter {string} and {string} and {string} and {string} and {string}")
    public void user_enter_watt_ave_and_north_highlands_and_california_and_and(String address, String city, String state, String zip, String phone) {
        registryPage.fillUpSecondScreenfieldsOfCreateRegristry(address, city, state, zip, phone);
    }

    @Then("user should be in the third screen")
    public void user_should_be_in_the_third_screen() {
        boolean status = registryPage.verifyThirdScreenGetsDisplayed();
        Assert.assertTrue(status);
    }

    @Then("user should able to see co-registrant checkbox is not selected as default")
    public void user_should_able_to_see_co_registrant_checkbox_is_not_selected_as_default() {
        boolean status = registryPage.verifyCoRegistrantCheckboxIsNotSelected();
        Assert.assertFalse(status);
    }

    @Given("click on checkbox for co-registrant")
    public void click_on_co_registrant_checkbox() {
        registryPage.clickOnCoRegistrantCheckBox();
    }

    @Then("user should able to see First name and Last name")
    public void user_should_able_to_see_first_name_and_last_name() {
        boolean status = registryPage.verifyFirstNameAndLastNameGetsDisplayed();
        Assert.assertTrue(status);
    }

    @Then("User should able to enter in {string} and {string} with minimum {int} character")
    public void user_should_able_to_enter_in_and_with_minimum_character(String firstName, String lastName, Integer int1) {
        boolean status = registryPage.enterFirstNameAndLastname(firstName, lastName);
        Assert.assertTrue(status);

    }

    @Then("User should able to see co-registrant form gets hidden")
    public void user_should_able_to_see_co_registrant_form_gets_hidden() {
        boolean status = registryPage.verifyCoRegistrantFormGetsHidden();
        Assert.assertFalse(status);
    }

    @Then("user should able to see the fields {string} and {string} and {string} when the form fields open")
    public void user_should_able_to_see_the_fields_and_and_when_the_form_fields_open(String string, String string2, String string3) {
        boolean status = registryPage.verifyEmailGetsDisplayed();
        Assert.assertTrue(status);
    }

    @Then("User should able to enter {string} and {string}")
    public void user_should_able_to_enter_and_and(String email, String confirmEmail) {
        boolean status = registryPage.enterEmailDetails(email, confirmEmail);
        Assert.assertTrue(status);
    }

    @Given("uncheck the co-registrant checkbox")
    public void uncheck_the_co_registrant_checkbox() {
        registryPage.uncheckCoRegistrant();
    }

    @Then("User should able to see email fields gets hidden after uncheck")
    public void user_should_able_to_see_email_fields_gets_hidden_after_uncheck() {
        registryPage.uncheckForAccessRegistry();
        boolean status = registryPage.verifyCoRegistrantFormGetsHiddenForAccessRegistry();
    }

    @Given("user click on checkbox for access this registry")
    public void user_click_on_checkbox_for_access_this_registry() {
        registryPage.clickOnCheckBoxForAccessRegistry();
    }

    @Then("user should able to see co-registrant checkbox is not selected as default to access this registry")
    public void user_should_able_to_see_co_registrant_checkbox_is_not_selected_as_default_to_access_this_registry() {
        boolean status = registryPage.verifyCoRegistrantCheckboxIsNotSelectedForAccessRegistry();
        Assert.assertFalse(status);
    }

}