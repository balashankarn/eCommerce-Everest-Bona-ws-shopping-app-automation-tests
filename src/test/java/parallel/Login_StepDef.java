package parallel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.driverfactory.DriverManager;
import com.driverfactory.Factory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.wsi.LoginPage;
import pom.wsi.PermissionPage;


public class Login_StepDef extends Factory {

    LoginPage login = new LoginPage(DriverManager.getDriver());
    PermissionPage permissionPage = new PermissionPage(DriverManager.getDriver());
    public static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    /************************************************Login Module Step Definitions
     * @throws Exception ************************************************/

//	@Given("user launches app enters the {string} in the search library page")
//	public void user_enters_the_in_the_search_library_page(String libname) throws Exception {
//		hooks.launchBrowser();
//		login=new LoginPage(DriverManager.getDriver());
//		login.navigatingToSignin();
//
//	}
//	@When("user enter the {string} and {string} and click on sign in button")
//	public void user_enter_the_and_and_click_on_sign_in_button(String libid, String bin) throws Exception {
//		login.libIdSelection(libid,bin);
//	}
//	@And("user views the list of profiles")
//	public void user_views_the_list_of_profiles() throws Exception {
//		login.verifyListofProfile();
//	}
//
//	@And("user selected {string} profile from list")
//	public void user_selected_child_profile_from_list(String profile) throws Exception {
//		login.registeradult(profile);
//
//	}
//	@Then("User navigates to registration form screen")
//	public void user_navigates_to_registration_form_screen() throws Exception {
//		login.profileCreation();
//	}
//
//    @Given("user launches apps and clicks on account setting button")
//    public void userLaunchesAppsAndClicksOnAccountSettingButton() {
//
//        //	login.selectEnviornment();
//    }
    @When("user clicks sign in option")
    public void userClicksSignInOption() {
        login.clickOnSignin();
    }

    @And("user enter username {string} and password {string} clicks on login")
    public void userEnterUsernameAndPasswordClicksOnLogin(String username, String password) {
        login.userEnterUserName(username);
        login.userEnterPassword(password);
        login.clickLoginBth();
    }

    @Then("user lands on dashboard screen")
    public void userLandsOnDashboardScreen() {
        login.navigatingToSignin();
        permissionPage.clickOnAllowOnce();
        boolean status = login.userLandsOnDashboard();
        Assert.assertTrue(status);
    }

    @When("user enter username {string} and password {string}")
    public void user_enter_username_and_password(String username, String password) {
        login.userEnterUserName(username);
        login.userEnterPassword(password);

    }

    @When("user click on Login Button")
    public void user_click_on_login_button() {
        login.clickLoginButton();
    }

    @Then("user should not able to navigate to next page")
    public void user_should_not_able_to_navigate_to_next_page() {
        boolean status = login.verifyTurnOnNotificationsIsNotDisplayed();
        Assert.assertFalse(status);
    }

}
