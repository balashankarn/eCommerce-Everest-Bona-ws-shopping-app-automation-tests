package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pom.wsi.RegistryPage;

public class MSHAPP_1041_StepDef {

    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());


    @When("user user clicks on MANAGE YOUR REGISTRIES")
    public void user_user_clicks_on_manage_your_registries() {

        registryPage.clickOnManageYourRegistries();
    }


    @Then("User should able to see the Primary registry is marked and highlighted")
    public void user_should_able_to_see_the_primary_registry_is_marked_and_highlighted() {

      boolean status =  registryPage.verifyFirstPrimaryRegistryIsMarkedAndHighlighted();
      Assert.assertTrue(status);
    }

    @When("user select other registry as Primary")
    public void user_select_other_primary_registry() {

        registryPage.selectOtherRegistryAsPrimary();
    }

    @Then("user should able to see the selected Primary registry is marked and highlighted")
    public void user_should_able_to_see_the_selected_primary_registry_is_marked_and_highlighted() {

       boolean status = registryPage.verifySelectedPrimaryIsMarkedAndHighlighted();
       Assert.assertTrue(status);
    }


}
