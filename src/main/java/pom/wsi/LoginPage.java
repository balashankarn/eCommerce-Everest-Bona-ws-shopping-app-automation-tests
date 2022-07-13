package pom.wsi;

import java.util.List;
import java.util.Map;

import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.driverfactory.DriverManager;
import com.google.common.collect.ImmutableMap;
import com.reusableMethods.CommonActions;
import com.utilities.ExcelReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LoginPage extends CommonActions {

    static ExcelReader reader = new ExcelReader();

    public static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    TabBarPage tabBarPage;
    PermissionPage permissionPage;
    AccountSettingPage accountSettingPage;
    public LoginPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @iOSXCUITFindBy(accessibility = "CONTINUE AS GUEST")
    private MobileElement btnContinueAsGuest;
    @iOSXCUITFindBy(accessibility = "START SHOPPING")
    private MobileElement btnStartShopping;
    @iOSXCUITFindBy(accessibility = "ACCOUNT")
    private MobileElement tbrAccount;
    @iOSXCUITFindBy(id = "SIGN IN")
    private MobileElement btnSignin;
    @iOSXCUITFindBy(accessibility = "Regression")
    private MobileElement btnresgression;
    @iOSXCUITFindBy(accessibility = "authentication_sign_in_button")
    private MobileElement btnLogin;
    @iOSXCUITFindBy(accessibility = "authtextfield_email_textfield")
    private MobileElement txtUsername;
    @iOSXCUITFindBy(accessibility = "authtextfield_password_textfield")
    private MobileElement txtPassword;
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement btnOK;
    @iOSXCUITFindBy(accessibility = "User Name")
    private MobileElement dashboard_Element;
    //@iOSXCUITFindBy(accessibility = "Debug")
    @iOSXCUITFindBy(accessibility = "debugOverlay")
    private MobileElement debug;
    @iOSXCUITFindBy(accessibility = "section0row1")
    private MobileElement selct_Site;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"pk\"])[2]")
    private MobileElement btnQA41;
    @iOSXCUITFindBy(accessibility = "ACCOUNT SETTINGS")
    private MobileElement btnAccountSetting;
    @iOSXCUITFindBy(accessibility = "NEXT")
    private MobileElement btnNext;


    public void navigatingToSignin() {
        WaitForMobileElement(btnContinueAsGuest);
        ClickOnMobileElement(btnContinueAsGuest);

        WaitForMobileElement(btnStartShopping);
        ClickOnMobileElement(btnStartShopping);


        WaitForMobileElement(tbrAccount);
        ClickOnMobileElement(tbrAccount);
    }

    public void selectEnviornment() {
        try {
            WaitForMobileElement(debug);
            ClickOnMobileElement(debug);
            WaitForMobileElement(selct_Site);
            ClickOnMobileElement(selct_Site);
            WaitForMobileElement(btnresgression);
            // ClickOnMobileElement(btnresgression);
            ClickOnMobileElement(btnQA41);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clickOnSignin() {
        WaitForMobileElement(btnSignin);
        ClickOnMobileElement(btnSignin);
    }

    public void userEnterUserName(String username) {
        try {
            WaitForMobileElement(txtUsername);
            txtUsername.sendKeys(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userEnterPassword(String password) {
        try {
            WaitForMobileElement(txtPassword);
            txtPassword.sendKeys(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickLoginBth() {
        WaitForMobileElement(btnLogin);
        btnLogin.click();
    }

    public void userLandsOnDashboard() {
        try {
            WaitForMobileElement(tbrAccount);
            //
            tbrAccount.click();
        } catch (Exception e) {
            WaitForMobileElement(btnOK);
            btnOK.click();

        }
    }

    public void scrollUp() {
        swipeUp();
    }

    public void scrollDown() {
        swipeDown();
    }
    public void signOut(){
        swipeUp();
        Assert.assertTrue(btnAccountSetting.isDisplayed());
        ClickOnMobileElement(btnAccountSetting);
        scrollDown();
    }




//public void visibility(){
//	Assert.assertTrue(siginin_Button);
//}


//	public void libSelection(String libName) throws Exception {
//
//		waitFor(9000);
//		WaitForMobileElement(txt_loginPg_search_lbl);
//		logger.info("User is on Login Page");
//		ClickOnMobileElement(txt_loginPg_search_lbl);
//		SendKeysOnMobileElement(txt_loginPg_search_lbl, libName);
//		logger.info("Library Name is Entered");
//		waitFor(3000);
//		DriverManager.getDriver().executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
//		ClickOnMobileElement(lxt_library_list_items.get(1));
//
//	}
//
//	public void libIdSelection(String libid, String bin) throws Exception {
//
//		waitFor(9000);
//		WaitForMobileElement(txt_loginPg_libid_lbl);
//		logger.info("User is on Login Page");
//		ClickOnMobileElement(txt_loginPg_libid_lbl);
//		SendKeysOnMobileElement(txt_loginPg_libid_lbl, libid);
//		logger.info("Library id is Entered");
//		waitFor(3000);
//		ClickOnMobileElement(txt_loginPg_libbin_lbl);
//		SendKeysOnMobileElement(txt_loginPg_libbin_lbl, bin);
//		logger.info("Library bin is Entered");
//		swipeDown();
//		hideMobileKeyboard();
//		WaitForMobileElement(btn_loginPg_signIn);
//		ClickOnMobileElement(btn_loginPg_signIn);
//	}
//
//	public void verifyListofProfile() throws Exception {
//
//		waitFor(9000);
//		WaitForMobileElement(txt_profile_adult_type);
//		Assert.assertEquals(txt_profile_adult_type.isDisplayed(), true);
//		Assert.assertEquals(txt_profile_teen_type.isDisplayed(), true);
//		Assert.assertEquals(txt_profile_child_type.isDisplayed(), true);
//	}
//
//	public void registeradult(String profile) throws Exception {
//
//		waitFor(9000);
//		if (profile.equalsIgnoreCase("Adult")) {
//			WaitForMobileElement(txt_profile_adult_type);
//			ClickOnMobileElement(txt_profile_adult_type);
//		} else if (profile.equalsIgnoreCase("Teen")) {
//			WaitForMobileElement(txt_profile_teen_type);
//			ClickOnMobileElement(txt_profile_teen_type);
//		} else if (profile.equalsIgnoreCase("Child")) {
//			WaitForMobileElement(txt_profile_child_type);
//			ClickOnMobileElement(txt_profile_child_type);
//		}
//	}
//
//	public void profileCreation() throws Exception {
//
//		List<Map<String, String>> testData = reader.getData("src/test/resources/Data/MobileData.xlsx", "Login");
//		WaitForMobileElement(txt_register_Form_Name);
//		SendKeysOnMobileElement(txt_register_Form_Name, testData.get(0).get("FullName"));
//		WaitForMobileElement(txt_register_Form_Email);
//		SendKeysOnMobileElement(txt_register_Form_Email, testData.get(0).get("Email"));
//		WaitForMobileElement(txt_register_Form_Mobile);
//		SendKeysOnMobileElement(txt_register_Form_Mobile, testData.get(0).get("MobileNo"));
//		ClickOnMobileElement(btn_register_Form);
//		WaitForMobileElement(chk_confirm_btn_no);
//		ClickOnMobileElement(chk_confirm_btn_no);
//
//	}

}
