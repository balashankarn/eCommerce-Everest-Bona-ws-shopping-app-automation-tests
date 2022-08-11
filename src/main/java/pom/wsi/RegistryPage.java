package pom.wsi;

import com.driverfactory.DriverManager;
import com.reusableMethods.CommonActions;
import com.utilities.ExcelReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.reusableMethods.CommonActions.Direction.DOWN;
import static com.reusableMethods.CommonActions.Direction.UP;

public class RegistryPage extends CommonActions {
    static ExcelReader reader = new ExcelReader();
    public static final Logger logger = LoggerFactory.getLogger(PermissionPage.class);

    public RegistryPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "ACCOUNT")
    private MobileElement tbrAccount;
    @iOSXCUITFindBy(id = "I want to add a message to my guests")
    private MobileElement lblAddToMyGuests;
    @iOSXCUITFindBy(accessibility = "REGISTRY")
    private MobileElement tbRegistry;
    @iOSXCUITFindBy(accessibility = "CREATE A REGISTRY")
    private MobileElement btnCreateARegistry;
    @iOSXCUITFindBy(accessibility = "FIND A REGISTRY")
    private MobileElement btnFindRegistry;
    @iOSXCUITFindBy(accessibility = "SIGN IN")
    private MobileElement btnNonLoggedInManageRegistry;
    @iOSXCUITFindBy(accessibility = "authtextfield_email_textfield")
    private MobileElement txtUsername;
    @iOSXCUITFindBy(accessibility = "authtextfield_password_textfield")
    private MobileElement txtPassword;
    @iOSXCUITFindBy(accessibility = "NEXT")
    private MobileElement btnNext;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[3]")
    private MobileElement txtAddress;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='Rectangle'])[1]")
    private MobileElement chkUseAddress;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[5]")
    private MobileElement txtCity;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[6]")
    private MobileElement txtState;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[7]")
    private MobileElement txtZip;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[8]")
    private MobileElement txtPhone;
    @iOSXCUITFindBy(accessibility = "authentication_sign_in_button")
    private MobileElement btnLogin;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[4]")
    private MobileElement spnSelectEventType;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[3]")
    private MobileElement spnSelectEventDate;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[5]")
    private MobileElement spnPrivacySetting;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePicker/XCUIElementTypePickerWheel")
    private MobileElement pickerWheel;
    @iOSXCUITFindBy(id = "I have a co-registrant")
    private MobileElement txtCoRegistrant;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='Rectangle'])[1]")
    private MobileElement chkCoRegistrantOne;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='Rectangle'])[2]")
    private MobileElement chkCoRegistrantTwo;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Allow my co-registrant to access this registry']")
    private MobileElement lblAllowMyCoRegistrant;
    @iOSXCUITFindBy(accessibility = "DONE")
    private MobileElement spnSelectEventTypeDone;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tuesday, July 5\"]")
    private MobileElement spnEventDate;
    @iOSXCUITFindBy(accessibility = "DONE")
    private MobileElement spnPrivacySettingDone;
    @iOSXCUITFindBy(accessibility = "checkmark.rectangle")
    private MobileElement chkAddress;
    @iOSXCUITFindBy(accessibility = "START SHOPPING")
    private MobileElement btnStartShopping;
    @iOSXCUITFindBy(accessibility = "SIGN IN")
    private MobileElement btnSignIN;
    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    private MobileElement btnAllowWhileUsingApp;
    @iOSXCUITFindBy(accessibility = "setting")
    private MobileElement btnAccountSetting;
    @iOSXCUITFindBy(accessibility = "DONE")
    private MobileElement spnSelectStateDone;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='checkmark.rectangle'])[1]")
    private MobileElement checkedCoRegistrant;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='checkmark.rectangle'])[2]")
    private MobileElement checkedCoRegistrantTwo;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    private MobileElement txtFirstName;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]")
    private MobileElement txtLastName;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[3]")
    private MobileElement txtEmail;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[4]")
    private MobileElement txtConfirmEmail;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[5]")
    private MobileElement txtNameYourRegistry;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    private MobileElement txtNameRegistry;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]")
    private MobileElement txtEnterYourGuestMessage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='0/300']")
    private MobileElement lblCharacterCount;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='checkmark.rectangle']")
    private MobileElement checkedAddToMyGuests;
    @iOSXCUITFindBy(accessibility = "SIGN OUT")
    private MobileElement btnSignOut;


    public void userClickOnRegistry() {
        waitForMobileElement(tbRegistry);
        clickOnMobileElement(tbRegistry);
    }

    public boolean userLandsOnRegistry() {
        try {
            waitForMobileElement(btnCreateARegistry);
            btnCreateARegistry.isDisplayed();
            btnFindRegistry.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean userInRegistryScreen() {
        try {
            btnFindRegistry.isDisplayed();
            btnCreateARegistry.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void userClickOnCreateRegistry() {
        clickOnMobileElement(btnCreateARegistry);
    }

    public void userLandsOnSignIn() {
        Assert.assertTrue(txtUsername.isDisplayed());
        Assert.assertTrue(txtPassword.isDisplayed());
    }

    public void userIsOnSignIn() {
        Assert.assertTrue(txtUsername.isDisplayed());
        Assert.assertTrue(txtPassword.isDisplayed());
    }

    public void userShouldLandOnCreateRegistryScreenOne() {
        waitForMobileElement(btnNext);
        Assert.assertTrue(btnNext.isDisplayed());
    }

    public void userIsOnCreateEventScreen() {
        waitForMobileElement(btnNext);
        Assert.assertTrue(btnNext.isDisplayed());
    }

    public void userEnterUserName(String username) {
        waitForMobileElement(txtUsername);
        txtUsername.sendKeys(username);
    }

    public void userEnterPassword(String password) {
        waitForMobileElement(txtPassword);
        txtPassword.sendKeys(password);
    }

    public void clickLoginBth() {
        waitForMobileElement(btnLogin);
        btnLogin.click();
    }

    public void selectEvenType(String eventType) {
        clickOnMobileElement(spnSelectEventType);
        waitVisibilityOfElement(pickerWheel);
        pickerWheel.sendKeys(eventType);
        clickOnMobileElement(spnSelectEventTypeDone);
    }

    public String verifyEventTypeValueGetsPopulated() {
        String eventTypeValue = spnSelectEventType.getAttribute("value");
        return eventTypeValue;
    }

    public void userClicksOnEvenTypeAndSelectsEventDate() {
        waitForMobileElement(spnSelectEventDate);
        spnSelectEventDate.click();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + getNextDay() + "']")).click();
    }

    public boolean theSelectDateAndEventShouldBeDisplayedthere() {
        String actualCurrentDate = spnSelectEventDate.getAttribute("value");
        if (!actualCurrentDate.isEmpty()) {
            return true;
        }
        return false;
    }

    public void userQuitsTheApp() {
        quitBrowser();
    }

    public void clickOnPrivacySettingAndSelectsPrivacy(String privacyTYpe) {
        clickOnMobileElement(spnPrivacySetting);
        waitVisibilityOfElement(pickerWheel);
        pickerWheel.sendKeys(privacyTYpe);
        waitFor(2000);

        clickOnMobileElement(spnPrivacySettingDone);
    }

    public String verifyPrivacyTYpeGetsDisplayed() {
        String privacyType = spnPrivacySetting.getAttribute("value");
        return privacyType;
    }

    public void userClicksOnNextButton() {
        waitForMobileElement(btnNext);
        clickOnMobileElement(btnNext);
    }

    public void userIsStepThreeScreen() {
        waitForMobileElement(btnNext);
        Assert.assertTrue(btnNext.isDisplayed());
    }

    public void startShopping() {
        waitForMobileElement(btnStartShopping);
        clickOnMobileElement(btnStartShopping);
    }

    public void userScrollToBottom() {
        waitFor(9000);
        swipeScreen(UP);
        waitFor(9000);
        swipeScreen(UP);
        waitFor(9000);
        swipeScreen(UP);
        waitFor(9000);
        swipeScreen(UP);
        waitFor(9000);
        swipeScreen(UP);
        waitFor(9000);
        swipeScreen(UP);
        waitFor(9000);
        swipeScreen(UP);
        waitFor(9000);
        swipeScreen(UP);
//waitFor(3000);
//swipeScreen(UP);
//waitFor(300);
//swipeScreen(UP);
        waitForMobileElement(btnCreateARegistry);
        Assert.assertTrue(btnCreateARegistry.isDisplayed());
        Assert.assertTrue(btnFindRegistry.isDisplayed());
        //   Assert.assertTrue(btnNonLoggedInManageRegistry.isDisplayed());
    }

    public void navigateToBackPage() {
        driver.navigate().back();
    }

    public void signOut() {
        scrollByPercentage(0.0, 0.90, 0.10);
        clickOnMobileElement(btnSignOut);
    }

    public void signOutIfAlreadySignedIn() {
        clickOnMobileElement(tbrAccount);
        clickOnMobileElement(btnAllowWhileUsingApp);
        try {
            btnSignIN.isDisplayed();
        } catch (Exception e) {
            clickOnMobileElement(btnAccountSetting);
            signOut();
            waitFor(2500);
        }
    }

    public void clickOnNextButton() {
        clickOnMobileElement(btnNext);
    }

    public void fillUpSecondScreenfieldsOfCreateRegristry(String address, String city, String state, String zip, String phone) {
        waitVisibilityOfElement(txtAddress);
        clickOnMobileElement(chkUseAddress);
        txtAddress.sendKeys(address);
        txtCity.sendKeys(city);
        txtZip.sendKeys(zip);
        txtState.click();
        pickerWheel.sendKeys(state);
        clickOnMobileElement(spnSelectStateDone);
        txtPhone.sendKeys(phone);
        scrollDown();
    }

    public boolean verifyThirdScreenGetsDisplayed() {
        waitVisibilityOfElement(txtCoRegistrant);
        return txtCoRegistrant.isDisplayed();
    }

    public boolean verifyCoRegistrantCheckboxIsNotSelected() {
        if (chkCoRegistrantOne.isSelected()) {
            return true;
        }
        return false;
    }

    public void clickOnCoRegistrantCheckBox() {
        clickOnMobileElement(chkCoRegistrantOne);
    }

    public boolean verifyFirstNameAndLastNameGetsDisplayed() {
        try {
            waitVisibilityOfElement(txtFirstName);
            txtFirstName.isDisplayed();
            txtLastName.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean enterFirstNameAndLastname(String firstName, String lastName) {
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        String actualFirstName = txtFirstName.getText();
        String actualLastName = txtLastName.getText();
        if (actualFirstName.equals(firstName) && actualLastName.equals(lastName)) {
            return true;
        }
        return false;
    }

    public void uncheckCoRegistrant() {
        clickOnMobileElement(checkedCoRegistrant);
    }

    public boolean verifyCoRegistrantFormGetsHidden() {
        try {
            lblAllowMyCoRegistrant.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnCoRegistrantCheckBoxToAccessRegistry() {
        clickOnMobileElement(chkCoRegistrantOne);
    }

    public boolean verifyEmailGetsDisplayed() {
        try {
            txtEmail.isDisplayed();
            txtConfirmEmail.isDisplayed();
            txtNameYourRegistry.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean enterEmailDetails(String email, String confirmEmail) {
        txtEmail.sendKeys(email);
        txtConfirmEmail.sendKeys(confirmEmail);
        String actualEmail = txtEmail.getText();
        String actualConfirmEmail = txtConfirmEmail.getText();
        if (actualEmail.equals(email) && actualConfirmEmail.equals(confirmEmail)) {
            return true;
        }
        return false;
    }

    public boolean verifyCoRegistrantFormGetsHiddenForAccessRegistry() {
        try {
            lblAllowMyCoRegistrant.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnCheckBoxForAccessRegistry() {
        clickOnMobileElement(chkCoRegistrantOne);
    }

    public void uncheckForAccessRegistry() {
        clickOnMobileElement(checkedCoRegistrantTwo);
        clickOnMobileElement(checkedCoRegistrant);
    }

    public boolean verifyCoRegistrantCheckboxIsNotSelectedForAccessRegistry() {
        scrollDown();
        if (chkCoRegistrantTwo.isSelected()) {
            return true;
        }
        return false;
    }

    public boolean verifyCharacterLimitForNameYourRegistry(String registryName, int characterCount) {
        waitVisibilityOfElement(txtNameRegistry);
        String extraCharacter = "testing";
        txtNameRegistry.sendKeys(registryName + extraCharacter);
        String actualRegistryName = txtNameRegistry.getText();
        if (actualRegistryName.equals(registryName) && actualRegistryName.length() == characterCount) {

            return true;
        }
        return false;
    }


    public boolean verifySpecialCharacterIsAllowedForNameYourRegistry(String registryName) {
        txtNameRegistry.clear();
        txtNameRegistry.sendKeys(registryName);
        String actualRegistryName = txtNameRegistry.getText();
        if (actualRegistryName.equals(registryName)) {

            return true;
        }
        return false;
    }

    public boolean verifyAddToGuestsLabelGetsDisplayed() {
        scrollDown();
        return lblAddToMyGuests.isDisplayed();
    }

    public boolean verifyCharacterLimitForEnterYourGuestMessage(int characterCount, String message) {
        waitVisibilityOfElement(txtEnterYourGuestMessage);
      int len =  message.length();
      System.out.println(len);
        String extraCharacter = "testing";
        txtEnterYourGuestMessage.sendKeys(message + extraCharacter);
        String actualRegistryName = txtEnterYourGuestMessage.getText();
        if (actualRegistryName.equals(message) && actualRegistryName.length() == characterCount) {

            return true;
        }
        return false;

    }

    public boolean verifyCharacterCountGetsDisplayedForEnterYourGuestMessage() {
          scrollDown();
        return lblCharacterCount.isDisplayed();

    }

    public boolean verifyCheckboxIsSelectedForAddMessageToMyGuests() {
        scrollDown();
        if (checkedAddToMyGuests.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean verifyEnterYourGuestMessageFieldGetsHidden() {
        try {
            lblCharacterCount.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnCheckboxForAddToMyGuests(){
        clickOnMobileElement(checkedAddToMyGuests);
    }

}



