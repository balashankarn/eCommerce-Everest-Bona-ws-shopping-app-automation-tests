package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pom.wsi.RegistryPage;

public class MSHAPP_1036_Stepdef {

    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());

    @Given("User click on Create Registry Button")
    public void user_click_on_create_registry_button() {
        registryPage.clickOnCreateRegistryButton();
    }

    @Given("User should able to see the message {string} in  confirmation screen")
    public void user_should_able_to_see_the_message_in_confirmation_screen(String expConfirmationScreenMessage) {
        String actualConfirmationScreenMessage = registryPage.verifyConfirmationScreenIsDisplayed();
        Assert.assertEquals(actualConfirmationScreenMessage, expConfirmationScreenMessage);
    }

    @Given("user enter Last name {string}")
    public void user_enter_last_name(String lastName) {
        registryPage.enterLastName(lastName);
    }

}
