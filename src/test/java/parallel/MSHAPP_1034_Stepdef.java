package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pom.wsi.RegistryPage;

public class MSHAPP_1034_Stepdef {

    RegistryPage registryPage = new RegistryPage(DriverManager.getDriver());

    @Then("User should able to see the checkbox to accept Gift cards is not checked")
    public void user_should_able_to_see_the_checkbox_to_accept_gift_cards_is_not_checked() {
      boolean status =  registryPage.verifyCheckboxIsNotSelectedForAcceptGiftCards();
        Assert.assertTrue(status);
    }

    @Then("User should able to select the checkbox to accept Gift card")
    public void user_should_able_to_select_the_checkbox_to_accept_gift_card() {
        boolean status =   registryPage.verifyCheckboxIsSelectedForAcceptGiftCards();
        Assert.assertTrue(status);
    }

    @Then("User should able to uncheck the checkbox to accept gift cards")
    public void user_should_able_to_uncheck_the_checkbox_to_accept_gift_cards() {
      boolean status =  registryPage.unchecksCheckBoxForAcceptGiftCards();
      Assert.assertTrue(status);
    }

}
