package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pom.wsi.*;

public class MSHAPP_1027_Stepdefs {

    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());

    @And("user clicks on event type and selects event date")
    public void userClicksOnEvenTypeAndSelectsEventDate() {
        registryPage.userClicksOnEvenTypeAndSelectsEventDate();
    }

    @Then("the selected event date should be populated here")
    public void theSelectedEventDateShouldBePopulatedHere() {
        boolean status = registryPage.theSelectDateAndEventShouldBeDisplayedthere();
        Assert.assertTrue(status);
    }

}
