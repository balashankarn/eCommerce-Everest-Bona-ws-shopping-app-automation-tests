package parallel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.driverfactory.DriverManager;
import com.driverfactory.Factory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.wsi.LoginPage;


public class Login_StepDef extends Factory{
	
	LoginPage login;
	Hooks hooks = new Hooks();
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


	@Given("user launches apps and clicks on account setting button")
	public void userLaunchesAppsAndClicksOnAccountSettingButton() {
		hooks.launchBrowser();
		login=new LoginPage(DriverManager.getDriver());
		login.selectEnviornment();
	}

	@When("user clicks sign in option")
	public void userClicksSignInOption() {

		login.navigatingToSignin();
		login.clickOnSignin();
	}

	@And("user enter username {string} and password {string} clicks on login")
	public void userEnterUsernameAndPasswordClicksOnLogin(String username, String password) {

	//	hooks.launchBrowser();
	//	login=new LoginPage(DriverManager.getDriver());

	//	DriverManager.getDriver().hideKeyboard();
		login.userEnterUserName(username);
//    	swipeScreen(5,5,5,1);
		//DriverManager.getDriver().navigate().back();
		login.userEnterPassword(password);
		login.clickLoginBth();



	}

	@Then("user lands on dashboard screen")
	public void userLandsOnDashboardScreen() {
		login.userLandsOnDashboard();


	}

//	@Then("user lands on Account setting screen")
//	public void userLandsOnAccountSettingScreen() {
//
//	}

//	@Then("user land on sign in screen")
//	public void userLandOnSignInScreen() {
//
//	}


}
