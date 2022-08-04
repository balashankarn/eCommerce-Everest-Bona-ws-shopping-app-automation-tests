package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @Then("user lands on step three screen")
    public void userLandsOnStepThreeScreen() {

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
    public void userClicksOnCreateRegistryInTheBottomOfTheScreen(){
        registryPage.userClickOnCreateRegistry();
    }
}
