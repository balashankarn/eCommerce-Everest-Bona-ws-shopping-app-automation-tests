package pom.wsi;

import java.util.List;
import java.util.Map;

import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
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
    @iOSXCUITFindBy(id = "START SHOPPING")
    private MobileElement btnStartShopping;
    @iOSXCUITFindBy(accessibility = "ACCOUNT")
    private MobileElement tbrAccount;
    @iOSXCUITFindBy(id = "SIGN IN")
    private MobileElement btnSignin;

    @iOSXCUITFindBy(id = "Allow")
    private MobileElement allowBtn;

    @iOSXCUITFindBy(accessibility = "SIGN IN")
    private MobileElement btnSignin2;

    @iOSXCUITFindBy(accessibility = "Regression")
    private MobileElement btnresgression;
    @iOSXCUITFindBy(accessibility = "authentication_sign_in_button")
    private MobileElement btnLogin;

    @iOSXCUITFindBy(id = "cart_share_button")
    private MobileElement turnOnNotifications;
    @iOSXCUITFindBy(accessibility = "Allow")
    private MobileElement allowButton;
    @iOSXCUITFindBy(id = "authtextfield_email_textfield")
    private MobileElement txtUsername;
    @iOSXCUITFindBy(id = "authtextfield_password_textfield")
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
        try {
            implicitWait(8);
            allowButton.click();
        } catch (Exception e) {

        }
        clickOnMobileElement(btnStartShopping);
        clickOnMobileElement(tbrAccount);
    }

    public void selectEnviornment() {
        try {
            waitForMobileElement(debug);
            clickOnMobileElement(debug);
            waitForMobileElement(selct_Site);
            clickOnMobileElement(selct_Site);
            waitForMobileElement(btnresgression);
            // ClickOnMobileElement(btnresgression);
            clickOnMobileElement(btnQA41);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clickOnSignin() {
        clickOnMobileElement(btnSignin);

    }

    public void userEnterUserName(String username) {
        waitVisibilityOfElement(txtUsername);
        txtUsername.click();
        sendKeysOnMobileElement(txtUsername, username);

    }

    public void userEnterPassword(String password) {
        waitForMobileElement(txtPassword);
        txtPassword.sendKeys(password);
    }

    public void clickLoginBth() {
        clickOnMobileElement(btnLogin);
        waitVisibilityOfElement(turnOnNotifications);
        waitFor(2000);
        turnOnNotifications.click();
        try {
            if (allowButton.isDisplayed()) {
                allowButton.click();
            }
        } catch (Exception e) {

        }
    }

    public void userLandsOnDashboard() {
        waitForMobileElement(tbrAccount);
        try {
            implicitWait(15);
            btnOK.click();
        } catch (Exception e) {


        }
    }

    public void scrollUp() {
        swipeUp();
    }

    public void scrollDown() {
        swipeDown();
    }

    public void signOut() {
        swipeUp();
        Assert.assertTrue(btnAccountSetting.isDisplayed());
        clickOnMobileElement(btnAccountSetting);
        scrollDown();
    }

    public void turnOnNotifications() {
        waitFor(3000);
        turnOnNotifications.click();
            for (int i = 0; i < 10; i++) {
                waitFor(1500);
                try {

                if (allowButton.isDisplayed()) {
                    allowButton.click();
                    break;
                }

            } catch(Exception e){
                System.out.println("it is not clicking");
            }
        }
    }
    }




