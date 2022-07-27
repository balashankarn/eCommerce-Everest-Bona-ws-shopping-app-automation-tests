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

    @iOSXCUITFindBy(accessibility = "SIGN IN")
    private MobileElement btnSignin2;

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
        WaitForMobileElement(btnSignin2);
        ClickOnMobileElement(btnSignin2);
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

}
