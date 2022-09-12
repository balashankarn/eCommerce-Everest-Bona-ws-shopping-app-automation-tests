package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pom.wsi.RegistryPage;

public class MSHAPP_1042_StepDef {
    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());
    @Then("User should able to see the SHARE icon is active of the Registry {string}")
    public void user_should_able_to_see_the_share_icon_is_active_of_the_registry(String registryName) {
      boolean status =  registryPage.verifyShareIconIsActive(registryName);
      Assert.assertTrue(status);
    }

    @When("click on SHARE icon of the Registry {string}")
    public void click_on_share_icon_of_the_registry(String registryName) {
        registryPage.clickOnShareIcon(registryName);
    }
    @Then("User should able to see default sharing options")
    public void user_should_able_to_see_default_sharing_options() {
       boolean status = registryPage.verifyDefaultSharingOptionIsDisplayed();
       Assert.assertTrue(status);
    }
    @Then("delete the existing Registry if it available already")
    public void delete_the_existing_registry_if_it_available_already() {
        registryPage.deleteExistingRegistry();
    }

}
