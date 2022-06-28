package parallel;

import com.driverfactory.DriverManager;
import com.driverfactory.Factory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.wsi.LoginPage;
import pom.wsi.OrderHistoryPage;

public class MSHAPP_524_StepDefs extends Factory {

    OrderHistoryPage orderHistoryPage = new OrderHistoryPage();
    @Given("user is in home page")
    public void userIsInHomePage() {
        orderHistoryPage.accountPage();
    }

    @When("user clicks on account tab")
    public void userClicksOnAccountTab() {
        orderHistoryPage.accountPageButtonClick();
    }

    @And("user clicks on order history link in my account page")
    public void userClicksOnOrderHistoryLinkInMyAccountPage() {
        orderHistoryPage.accountPageClickOrderHistory();
    }

    @Then("user checks whether he is order page or not")
    public void userChecksWhetherHeIsOrderPageOrNot() {
        orderHistoryPage.userIsInOrderHistoryPage();

    }

}
