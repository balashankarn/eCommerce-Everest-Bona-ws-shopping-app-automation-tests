package pom.wsi;

import com.driverfactory.DriverManager;
import com.reusableMethods.CommonActions;
import com.utilities.ExcelReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountSettingPage extends CommonActions {
    static ExcelReader reader = new ExcelReader();
    public static final Logger logger = LoggerFactory.getLogger(AccountSettingPage.class);


    public AccountSettingPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(id = "CHANGE")
    private MobileElement btnPasswordChange;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"EDIT\"])[2]")
    private MobileElement btnEmailEdit;
    @iOSXCUITFindBy(accessibility = "Edit Email Address")
    private MobileElement editEmailAddressHeader;
    @iOSXCUITFindBy(accessibility = "authtextfield_password_textfield")
    private MobileElement txtCurrentPasswordEditEmail;
    @iOSXCUITFindBy(accessibility = "authtextfield_email_textfield")
    private MobileElement txtNewEmailAddressEditEmail;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SAVE']")
    private MobileElement btnSaveEditEmail;
    @iOSXCUITFindBy(id = "Close")
    private MobileElement btnCloseEditEmail;
    @iOSXCUITFindBy(id = "Change Password")
    private MobileElement changePasswordHeader;
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeOther/XCUIElementTypeSecureTextField[1]")
    private MobileElement currentPassword;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeSecureTextField[2]")
    private MobileElement newPassword;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private MobileElement newEmailAddress;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField")
    private MobileElement newEmailPassword;
    @iOSXCUITFindBy(id = "(//XCUIElementTypeSecureTextField[@name='authtextfield_password_textfield'])[1]")
    private MobileElement txtCurrentPassword;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSecureTextField[@name='authtextfield_password_textfield'])[2]")
    private MobileElement txtNewPassword;
    @iOSXCUITFindBy(accessibility = "CREATE ACCOUNT")
    private MobileElement createAccount;
    @iOSXCUITFindBy(id = "ACCOUNT SETTINGS")
    private MobileElement accountSetting;
    @iOSXCUITFindBy(id = "MY PROFILE")
    private MobileElement myProfile;



    public void navigateToEditEmail() {
            waitForMobileElement(btnEmailEdit);
            btnEmailEdit.click();
    }

    public void verifyEditEmailScreen() {
        waitForMobileElement(newEmailAddress);
            newEmailAddress.isDisplayed();
            editEmailAddressHeader.isDisplayed();
            newEmailPassword.isDisplayed();
    }

    public boolean verifyEntireEditEmailUI() {
        waitForMobileElement(newEmailPassword);
        try {
            newEmailPassword.isDisplayed();
            newEmailAddress.isDisplayed();
            btnSaveEditEmail.isDisplayed();
            btnCloseEditEmail.isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }

    }

    public void userAbleToTapOnBothFeild() {
        clickOnMobileElement(newEmailAddress);
        clickOnMobileElement(newEmailPassword);
    }

    public void userEnterCurrentPassword(String currentpassword) {
        waitForMobileElement(currentPassword);
        currentPassword.sendKeys(currentpassword);
    }

    public void userEnterEmailAddress(String newemailaddress) {
        waitForMobileElement(newEmailAddress);
        newEmailAddress.sendKeys(newemailaddress);
    }

    public boolean userClicksOnCloseButton() throws InterruptedException {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(btnCloseEditEmail).click().perform();
            waitVisibilityOfElement(myProfile);
            myProfile.isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }

    }

    public boolean  verifyScreenUI() {
        waitForMobileElement(btnPasswordChange);
        return btnPasswordChange.isDisplayed();
    }

    public void viewChangeOption() {
        waitForMobileElement(btnPasswordChange);
        Assert.assertTrue(btnPasswordChange.isDisplayed());
    }

    public void navigateToChangePassword() {
        waitForMobileElement(btnPasswordChange);
        btnPasswordChange.click();
    }

    public boolean passwordScreenUI() {
        waitForMobileElement(currentPassword);
        try {
            changePasswordHeader.isDisplayed();
            currentPassword.isDisplayed();
            newPassword.isDisplayed();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void userClickSOnCurrentPassword() {
        clickOnMobileElement(currentPassword);
        clickOnMobileElement(newPassword);
    }

    public void userEnterNewPassword(String newpassword) {
            waitForMobileElement(newPassword);
            newPassword.sendKeys(newpassword);
    }

    public void closeTheApp() {
        quitBrowser();
    }

}
