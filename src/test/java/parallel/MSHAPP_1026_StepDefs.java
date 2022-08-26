package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pom.wsi.*;

public class MSHAPP_1026_StepDefs {
    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());

    @Given("user  is on create event screen")
    public void userIsOnCreateEventScreen() {
        registryPage.userShouldLandOnCreateRegistryScreenOne();
    }


    @Given("user select the event type as {string}")
    public void user_select_the_event_type_as(String eventType) {
        registryPage.selectEvenType(eventType);
    }

    @Then("user should able to see the selected value {string} in event type")
    public void user_should_able_to_see_the_selected_value_in_event_type(String expEventTypeValue) {
        String actualEventTypeValue = registryPage.verifyEventTypeValueGetsPopulated();
        Assert.assertEquals(actualEventTypeValue, expEventTypeValue);
    }

}
