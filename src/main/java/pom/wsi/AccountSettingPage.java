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
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountSettingPage extends CommonActions {
    static ExcelReader reader = new ExcelReader();
    public static final Logger logger = LoggerFactory.getLogger(AccountSettingPage.class);


    public AccountSettingPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "CHANGE")
    private MobileElement btnPasswordChange;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"EDIT\"])[2]")
    private MobileElement btnEmailEdit;
    @iOSXCUITFindBy(accessibility = "Edit Email Address")
    private MobileElement editEmailAddressHeader;
    @iOSXCUITFindBy(accessibility = "authtextfield_password_textfield")
    private MobileElement txtCurrentPasswordEditEmail;
    @iOSXCUITFindBy(accessibility = "authtextfield_email_textfield")
    private MobileElement txtNewEmailAddressEditEmail;
    @iOSXCUITFindBy(accessibility = "SAVE")
    private MobileElement btnSaveEditEmail;
    @iOSXCUITFindBy(accessibility = "xmark")
    private MobileElement btnCloseEditEmail;
    @iOSXCUITFindBy(accessibility = "Change Password")
    private MobileElement changePasswordHeader;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSecureTextField[@name=\"authtextfield_password_textfield\"])[1]")
    private MobileElement txtCurrentPassword;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSecureTextField[@name=\"authtextfield_password_textfield\"])[2]")
    private MobileElement txtNewPassword;

    public void navigateToEditEmail() {

        try {
            WaitForMobileElement(btnEmailEdit);
            btnEmailEdit.click();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void verifyEditEmailScreen() {
        WaitForMobileElement(editEmailAddressHeader);
        Assert.assertTrue(editEmailAddressHeader.isDisplayed());
        WaitForMobileElement(txtCurrentPasswordEditEmail);
        Assert.assertTrue(txtCurrentPasswordEditEmail.isDisplayed());
    }

    public void verifyEntireEditEmailUI() {
        try {
            WaitForMobileElement(txtCurrentPasswordEditEmail);
            Assert.assertTrue(txtCurrentPasswordEditEmail.isDisplayed());
            Assert.assertTrue(txtNewEmailAddressEditEmail.isDisplayed());
            Assert.assertTrue(btnSaveEditEmail.isDisplayed());
            //   Assert.assertTrue(btnCloseEditEmail.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void userAbleToTapOnBothFeild() {
        WaitForMobileElement(txtCurrentPasswordEditEmail);
        txtCurrentPassword.click();
        txtCurrentPassword.sendKeys("hello");
        txtCurrentPassword.clear();
        WaitForMobileElement(txtNewEmailAddressEditEmail);
        txtNewEmailAddressEditEmail.click();
        txtNewEmailAddressEditEmail.sendKeys("bala@123.com");
        txtNewEmailAddressEditEmail.clear();
        DriverManager.getDriver().hideKeyboard();
    }

    public void userEnterCurrentPassword(String currentpassword) {
        try {
            WaitForMobileElement(txtCurrentPasswordEditEmail);
            txtCurrentPassword.sendKeys(currentpassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userEnterEmailAddress(String newemailaddress) {
        try {
            WaitForMobileElement(txtNewEmailAddressEditEmail);
            txtNewEmailAddressEditEmail.sendKeys(newemailaddress);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void userClicksOnCloseButton() throws InterruptedException {

        //TouchActionClick(btnCloseEditEmail);
        driver.navigate().back();

    }

    public void verifyScreenUI() {

        WaitForMobileElement(btnPasswordChange);
        Assert.assertTrue(btnEmailEdit.isDisplayed());
        Assert.assertTrue(btnPasswordChange.isDisplayed());
    }

    public void viewChangeOption() {
        WaitForMobileElement(btnPasswordChange);
        Assert.assertTrue(btnPasswordChange.isDisplayed());
    }


    public void navigateToChangePassword() {
        WaitForMobileElement(btnPasswordChange);
        btnPasswordChange.click();

    }

    public void passwordScreenUI() {
        WaitForMobileElement(changePasswordHeader);
        Assert.assertTrue(changePasswordHeader.isDisplayed());
        Assert.assertTrue(txtCurrentPassword.isDisplayed());
        Assert.assertTrue(txtNewPassword.isDisplayed());
    }

    public void userClickSOnCurrentPassword() {
        try {
            WaitForMobileElement(txtCurrentPassword);
            txtCurrentPassword.click();
            txtNewPassword.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void userEnterNewPassword(String newpassword) {
        try {
            WaitForMobileElement(txtNewPassword);
            txtNewPassword.sendKeys(newpassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void closeTheApp() {
        quitBrowser();
    }

}
