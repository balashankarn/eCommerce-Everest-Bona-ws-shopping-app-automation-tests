package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.wsi.RegistryPage;

public class MSHAPP_1035_Stepdef {

    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());

    @Then("User should able to see the information {string} in readable view")
    public void user_should_able_to_see_the_information_in_readable_view(String string) {
        registryPage.verifyBeforeAndAfterEventInfoIsDisplayed();
    }

    @When("User click on Edit Button")
    public void user_click_on_edit_button() {
        registryPage.clickOnEditBtn();
    }

    @Then("User should Navigate to the second screen")
    public void user_should_navigate_to_the_second_screen() {
        registryPage.navigateToSecondScreen();
    }

    @Then("User should able to Edit {string} in Second Screen information and move to third screen")
    public void user_should_able_to_edit_in_second_screen_and_move_to_third_screen(String expLastName) {
        String actualLastName = registryPage.verifySecondScreenInformationEditable(expLastName);
        Assert.assertEquals(actualLastName, expLastName);
    }

    @Then("User should able to see the Step one information {string},{string},{string} in Step three screen")
    public void user_should_able_to_see_the_step_one_information_in_step_three_screen(String firstAndLastName, String eventType, String eventDate) {
        boolean status = registryPage.verifyStepOneInformationAreDisplayedInStepThreeScreen(firstAndLastName, eventType, eventDate);
        Assert.assertTrue(status);
    }

}
