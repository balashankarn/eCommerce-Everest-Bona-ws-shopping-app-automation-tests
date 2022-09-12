package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pom.wsi.RegistryPage;

import java.util.ArrayList;
import java.util.List;

public class MSHAPP_1043_StepDef {
    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());

    @Then("User navigate to backPage")
    public void user_navigate_to_back_page() {
        registryPage.navigateToBack();
    }

    @When("click on Edit button of the Registry {string}")
    public void click_on_edit_button_of_the_registry(String registryName) {
        registryPage.clickOnManageRegistryEditButton(registryName);
    }

    @Then("user should able to edit the Tell us about your special day section")
    public void user_should_able_to_edit_the_tell_us_about_your_special_day_section() {
       boolean status = registryPage.verifyTellUsAboutYourSpecialDaySectionEditable();
        Assert.assertTrue(status);
    }

    @Then("user should able to edit the WHEN IS THE EVENT section")
    public void user_should_able_to_edit_the_when_is_the_event_section() {
       boolean status = registryPage.verifyWhenIsTheEventSectionEditable();
       Assert.assertTrue(status);
    }


    @Then("user should able to edit the SHIPPING ADDRESS section")
    public void user_should_able_to_edit_the_shipping_address_section() {
       boolean status = registryPage.verifyShippingAddressSectionEditable();
       Assert.assertTrue(status);
    }

    @Then("user should able to edit the CO-REGISTRANT INFORMATION  section")
    public void user_should_able_to_edit_the_co_registrant_information_section() {
      boolean status =  registryPage.verifyCoRegistrantSectionEditable();
      Assert.assertTrue(status);
    }

    @Then("user should able to edit the POTTERY BARN KIDS section")
    public void user_should_able_to_edit_the_pottery_barn_kids_section() {
      boolean status =  registryPage.verifyPotteryBarnKidsSectionEditable();
      Assert.assertTrue(status);
    }

    @Then("user should able to edit the WHAT ARE YOUR REGISTRY PREFERENCES section")
    public void user_should_able_to_edit_the_what_are_your_registry_preferences_section() {
       boolean status = registryPage.verifyWhatAreYourRegistryPreferencesSectionEditable();
       Assert.assertTrue(status);
    }

}
