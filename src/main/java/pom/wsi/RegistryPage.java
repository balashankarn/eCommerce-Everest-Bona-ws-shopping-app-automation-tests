package pom.wsi;

import com.driverfactory.DriverManager;
import com.reusableMethods.CommonActions;
import com.utilities.ExcelReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
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
    @iOSXCUITFindBy(accessibility = "REGISTRY")
    private MobileElement tbRegistry;
    @iOSXCUITFindBy(accessibility = "SIGN OUT")
    private MobileElement signOut;
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
    @iOSXCUITFindBy(accessibility = "authentication_sign_in_button")
    private MobileElement btnLogin;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[4]")
    private MobileElement spnSelectEventType;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePicker/XCUIElementTypePickerWheel")
    private List<MobileElement> pickerWheel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[3]")
    private MobileElement spnSelectEventDate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[5]")
    private MobileElement spnPrivacySetting;
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
    private MobileElement signIN;
    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    private MobileElement btnAllowWhileUsingApp;
    @iOSXCUITFindBy(accessibility = "setting")
    private MobileElement btnAccountSetting;

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
        }catch(Exception e){
            return false;
        }
    }
    public boolean userInRegistryScreen() {
        try {
            btnFindRegistry.isDisplayed();
            btnCreateARegistry.isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public void userClickOnCreateRegistry(){
            clickOnMobileElement(btnCreateARegistry);
    }

   public  void userLandsOnSignIn(){
        Assert.assertTrue(txtUsername.isDisplayed());
       Assert.assertTrue(txtPassword.isDisplayed());
   }

   public void userIsOnSignIn(){
       Assert.assertTrue(txtUsername.isDisplayed());
       Assert.assertTrue(txtPassword.isDisplayed());
   }

   public void userShouldLandOnCreateRegistryScreenOne(){
        waitForMobileElement(btnNext);
        Assert.assertTrue(btnNext.isDisplayed());
   }

   public void userIsOnCreateEventScreen(){
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

    public void selectEvenType(){
        clickOnMobileElement(spnSelectEventType);
        clickOnMobileElement(spnSelectEventTypeDone);
    }

    public String verifyEventTypeValueGetsPopulated(){
       String eventTypeValue = spnSelectEventType.getAttribute("value");
       return eventTypeValue;
    }

   public void userClicksOnEvenTypeAndSelectsEventDate(){
       waitForMobileElement(spnSelectEventDate);
       spnSelectEventDate.click();
      spnSelectEventDate.sendKeys(getCurrentDate());
   }

   public boolean theSelectDateAndEventShouldBeDisplayedthere(){
     String actualCurrentDate =  spnSelectEventDate.getAttribute("value");
     if(!actualCurrentDate.isEmpty()){
         return true;
     }
     return false;
   }

   public void userQuitsTheApp(){
        quitBrowser();
   }

   public void clickOnPrivacySettingAndSelectsPrivacy(){
       clickOnMobileElement(spnPrivacySetting);
       clickOnMobileElement(spnPrivacySettingDone);
   }

   public String verifyPrivacyTYpeGetsDisplayed(){
       String privacyType = spnPrivacySetting.getAttribute("value");
       return privacyType;

    }

   public void userClicksOnNextButton(){
            waitForMobileElement(btnNext);
            clickOnMobileElement(btnNext);
   }
   public void userIsStepThreeScreen(){
        waitForMobileElement(btnNext);
        Assert.assertTrue(btnNext.isDisplayed());
}

      public void startShopping(){
        waitForMobileElement(btnStartShopping);
        clickOnMobileElement(btnStartShopping);
}

  public void userScrollToBottom(){
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

    public void navigateToBackPage(){
        driver.navigate().back();
    }

    public void signOut(){
      scrollByPercentage(0.0,0.50,0.10);
        swipeDown();
        clickOnMobileElement(signOut);
    }


    public void signOutIfAlreadySignedIn(){
        clickOnMobileElement(tbrAccount);
        clickOnMobileElement(btnAllowWhileUsingApp);
        try{
            signIN.isDisplayed();
        }catch(Exception e){
            clickOnMobileElement(btnAccountSetting);
            signOut();
            waitFor(2500);
        }
    }

}
