package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pom.wsi.RegistryPage;

public class MSHAPP_1033_Stepdef {
    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());

    @Then("User should able to enter a name {string} with maximum of {int} character")
    public void user_should_able_to_enter_a_name_with_maximum_of_character(String registryName, Integer characterCount) {
        boolean status = registryPage.verifyCharacterLimitForNameYourRegistry(registryName, characterCount);
        Assert.assertTrue(status);
    }

    @Then("User should able to enter special character {string}")
    public void user_should_able_to_enter_special_character(String registryName) {
        boolean status = registryPage.verifySpecialCharacterIsAllowedForNameYourRegistry(registryName);
        Assert.assertTrue(status);
    }

    @Then("User should able to see label {string}")
    public void user_should_able_to_see_label(String string) {
        boolean status = registryPage.verifyAddToGuestsLabelGetsDisplayed();
        Assert.assertTrue(status);
    }

    @Then("User should able to enter a maximum of {int} characters {string} in the message field")
    public void user_should_able_to_enter_a_maximum_of_characters_in_the_message_field(Integer characterCount, String message) {
        boolean status = registryPage.verifyCharacterLimitForEnterYourGuestMessage(characterCount, message);
        Assert.assertTrue(status);
    }

    @Then("User should able to see the character count as {string} after entering the below Message")
    public void user_should_able_to_see_the_character_count_as_after_entering_the_below_message(String string) {
        boolean status = registryPage.verifyCharacterCountGetsDisplayedForEnterYourGuestMessage();
        Assert.assertTrue(status);
    }

    @Then("User should able to see the checkbox to add message to guests gets checked")
    public void user_should_able_to_see_the_checkbox_to_add_message_to_guests_gets_checked() {
        boolean status = registryPage.verifyCheckboxIsSelectedForAddMessageToMyGuests();
        Assert.assertTrue(status);
    }

    @Then("User should able to see the Enter the guest message field should be hidden")
    public void user_should_able_to_see_the_enter_the_guest_message_field_should_be_hidden() {
        boolean status = registryPage.verifyEnterYourGuestMessageFieldGetsHidden();
        Assert.assertFalse(status);
    }
    @Given("click on checkbox for add a message to my guests")
    public void click_on_checkbox_for_add_a_message_to_my_guests() {
        registryPage.clickOnCheckboxForAddToMyGuests();
    }
}