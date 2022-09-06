package pom.wsi;

import com.driverfactory.DriverManager;
import com.reusableMethods.CommonActions;
import com.utilities.ExcelReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
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
    public static String actualCurrentDate = "";
    By nextDay = MobileBy.xpath("//XCUIElementTypeStaticText[@name='" + getNextDay() + "']");

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
    @iOSXCUITFindBy(accessibility = "MANAGE YOUR REGISTRIES")
    private MobileElement btnManageYourRegistries;
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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='30']")
    private MobileElement date;
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
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='Rectangle'])[2]")
    private MobileElement chkToAcceptGiftCards;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='checkmark.rectangle'])[2]")
    private MobileElement checkedAddToAcceptGiftCards;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='EDIT'])[2]")
    private MobileElement btnEditTwo;
    @iOSXCUITFindBy(accessibility = "Before & After Event")
    private MobileElement txtBeforeAndAfterEvent;

    @iOSXCUITFindBy(accessibility = "CREATE REGISTRY")
    private MobileElement btnCreateARegistryTwo;

    @iOSXCUITFindBy(id = "Congratulations, you’re registered!")
    private MobileElement lblCongratulations;

    @iOSXCUITFindBy(accessibility = "Registry")
    private MobileElement lblRegistry;

    @iOSXCUITFindBy(accessibility = "DELETE REGISTRY")
    private MobileElement lblDeleteRegistry;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Create Registry']")
    private MobileElement lblCreateARegistry;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='TELL US ABOUT YOUR SPECIAL DAY']/following::XCUIElementTypeButton)[1]")
    private MobileElement btnTellUsAboutYourSpecialDayEdit;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='WHEN IS THE EVENT']/following::XCUIElementTypeButton)[1]")
    private MobileElement btnWhenIsTheEventSectionEdit;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='SHIPPING ADDRESS']/following::XCUIElementTypeButton)[1]")
    private MobileElement btnShippingAddressSectionEdit;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='CO-REGISTRANT INFORMATION']/following::XCUIElementTypeButton)[1]")
    private MobileElement btnCoRegistrantSectionEdit;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='POTTERY BARN KIDS GIFT CARDS']/following::XCUIElementTypeButton)[1]")
    private MobileElement btnPotteryBarnKidsSectionEdit;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='WHAT ARE YOUR REGISTRY PREFERENCES?']/following::XCUIElementTypeButton)[1]")
    private MobileElement btnWhatAreYourRegistryPreferenceSectionEdit;

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

    public void selectsEventDate() {
        clickOnMobileElement(spnSelectEventDate);
        DriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + getNextDay() + "']")).click();
    }

    public boolean verifySelectedDateIsDisplayed(){
        waitForMobileElement(spnSelectEventDate);
        actualCurrentDate = spnSelectEventDate.getAttribute("value");
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
        DriverManager.getDriver().navigate().back();
    }

    public void signOut() {
        scrollUp();
        clickOnMobileElement(btnSignOut);
    }

    public void signOutIfAlreadySignedIn() {
        clickOnMobileElement(tbrAccount);
        clickOnMobileElement(btnAllowWhileUsingApp);
        try {
            implicitWait(10);
            btnAccountSetting.click();
            clickOnMobileElement(btnSignOut);
        } catch (Exception e) {

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
        waitFor(1500);
        txtPhone.click();
        txtPhone.sendKeys(phone);
        scrollUp();
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
        scrollUp();
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
        scrollUp();
        return lblAddToMyGuests.isDisplayed();
    }

    public boolean verifyCharacterLimitForEnterYourGuestMessage(int characterCount, String message) {
        waitVisibilityOfElement(txtEnterYourGuestMessage);
        String extraCharacter = "testing";
        txtEnterYourGuestMessage.click();
        txtEnterYourGuestMessage.sendKeys(message + extraCharacter);
        String actualRegistryName = txtEnterYourGuestMessage.getText();
        if (actualRegistryName.equals(message) && actualRegistryName.length() == characterCount) {

            return true;
        }
        return false;
    }

    public boolean verifyCharacterCountGetsDisplayedForEnterYourGuestMessage() {
        scrollUp();
        return lblCharacterCount.isDisplayed();
    }

    public boolean verifyCheckboxIsSelectedForAddMessageToMyGuests() {
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

    public void clickOnCheckboxForAddToMyGuests() {
        clickOnMobileElement(checkedAddToMyGuests);
    }


    public boolean verifyCheckboxIsNotSelectedForAcceptGiftCards() {
        scrollUp();
        if (!chkToAcceptGiftCards.isSelected()) {
            return true;
        }
        return false;
    }

    public boolean verifyCheckboxIsSelectedForAcceptGiftCards() {
        clickOnMobileElement(chkToAcceptGiftCards);
        if (checkedAddToAcceptGiftCards.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean unchecksCheckBoxForAcceptGiftCards() {
        clickOnMobileElement(checkedAddToAcceptGiftCards);
        if (!chkToAcceptGiftCards.isSelected()) {
            return true;
        }
        return false;
    }

    public boolean verifyBeforeAndAfterEventInfoIsDisplayed() {
        return txtBeforeAndAfterEvent.isDisplayed();
    }

    public void clickOnEditBtn() {
        clickOnMobileElement(btnEditTwo);
    }

    public boolean navigateToSecondScreen() {
        return txtLastName.isDisplayed();
    }

    public String verifySecondScreenInformationEditable(String lastName) {
        txtLastName.click();
        txtLastName.clear();
        waitFor(1500);
        txtLastName.sendKeys(lastName);
        lastName = txtLastName.getText();
        scrollUp();
        clickOnMobileElement(btnNext);
        return lastName;
    }

    public boolean verifyStepOneInformationAreDisplayedInStepThreeScreen(String firstAndLastName, String eventType, String eventDate) {
        try {
            DriverManager.getDriver().findElement(By.id(eventType)).isDisplayed();
            eventDate = actualCurrentDate;
            String eventDateAndFirstAndLastName = eventDate + " " + firstAndLastName;
         //   DriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+eventDateAndFirstAndLastName+"']")).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnCreateRegistryButton(){
        scrollUp();
        clickOnMobileElement(btnCreateARegistryTwo);
    }

    public String verifyConfirmationScreenIsDisplayed(){
       return lblCongratulations.getText();
    }

    public void clickOnManageYourRegistries(){
        waitVisibilityOfElement(lblRegistry);
        waitFor(2000);
        scrollByPercentage(0.0,0.90,0.10);
        waitFor(2000);
        scrollByPercentage(0.0,0.90,0.10);
        waitFor(2000);
        scrollByPercentage(0.0,0.90,0.10);
        clickOnMobileElement(btnManageYourRegistries);
    }

    public boolean verifyFirstPrimaryRegistryIsMarkedAndHighlighted(){
       //logic need to be implemented

        return true;
    }

    public void selectOtherRegistryAsPrimary(){

        //logic need to be implemented
    }

    public boolean verifySelectedPrimaryIsMarkedAndHighlighted(){

        //logic need to be implemented

        return true;

    }

    public void navigateToBack(){

        navigateToBackPage();
    }

    public void clickOnManageRegistryEditButton(String registryName){
        DriverManager.getDriver().findElement(By.xpath("(//XCUIElementTypeStaticText[@name='"+registryName+"']/following::XCUIElementTypeStaticText[@name='EDIT'])[1]")).click();
    }

    public boolean verifyTellUsAboutYourSpecialDaySectionEditable(){
        try {
            waitVisibilityOfElement(lblDeleteRegistry);
            clickOnMobileElement(btnTellUsAboutYourSpecialDayEdit);
            lblCreateARegistry.isDisplayed();
            waitFor(2000);
            navigateToBackPage();
            waitVisibilityOfElement(lblDeleteRegistry);
            return true;
        }
        catch (Exception e){
            return false;
        }
        }

    public boolean verifyWhenIsTheEventSectionEditable(){
        try {
            waitVisibilityOfElement(lblDeleteRegistry);
            clickOnMobileElement(btnWhenIsTheEventSectionEdit);
            lblCreateARegistry.isDisplayed();
            waitFor(2000);
            navigateToBackPage();
            waitVisibilityOfElement(lblDeleteRegistry);
            return true;
        }catch (Exception e){
           return false;
        }

    }

    public boolean verifyShippingAddressSectionEditable() {
        try {
            waitVisibilityOfElement(lblDeleteRegistry);
            clickOnMobileElement(btnShippingAddressSectionEdit);
            lblCreateARegistry.isDisplayed();
            waitFor(2000);
            navigateToBackPage();
            waitVisibilityOfElement(lblDeleteRegistry);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyCoRegistrantSectionEditable(){
        try {
            waitVisibilityOfElement(lblDeleteRegistry);
            waitFor(2000);
            scrollUp();
            clickOnMobileElement(btnCoRegistrantSectionEdit);
            lblCreateARegistry.isDisplayed();
            waitFor(2000);
            navigateToBackPage();
            waitVisibilityOfElement(lblDeleteRegistry);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean verifyPotteryBarnKidsSectionEditable(){
        try {
            waitVisibilityOfElement(lblDeleteRegistry);
            waitFor(2000);
            scrollUp();
            clickOnMobileElement(btnPotteryBarnKidsSectionEdit);
            lblCreateARegistry.isDisplayed();
            waitFor(2000);
            navigateToBackPage();
            waitVisibilityOfElement(lblDeleteRegistry);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean verifyWhatAreYourRegistryPreferencesSectionEditable(){
        try {
            waitVisibilityOfElement(lblDeleteRegistry);
            waitFor(2000);
            scrollUp();
            clickOnMobileElement(btnWhatAreYourRegistryPreferenceSectionEdit);
            lblCreateARegistry.isDisplayed();
            waitFor(2000);
            navigateToBackPage();
            waitVisibilityOfElement(lblDeleteRegistry);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    }








