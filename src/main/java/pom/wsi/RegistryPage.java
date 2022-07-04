package pom.wsi;

import com.reusableMethods.CommonActions;
import com.utilities.ExcelReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistryPage extends CommonActions {
    static ExcelReader reader = new ExcelReader();
    public static final Logger logger = LoggerFactory.getLogger(PermissionPage.class);

    public RegistryPage(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

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
    @iOSXCUITFindBy(accessibility = "authentication_sign_in_button")
    private MobileElement btnLogin;


    public void userClickOnRegistry() {
        try {
            WaitForMobileElement(tbRegistry);
            ClickOnMobileElement(tbRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userLandsOnRegistry() {
        Assert.assertTrue(btnCreateARegistry.isDisplayed());
        Assert.assertTrue(btnFindRegistry.isDisplayed());
     //   Assert.assertTrue(btnNonLoggedInManageRegistry.isDisplayed());
    }

    public void userInRegistryScreen() {
        Assert.assertTrue(btnFindRegistry.isDisplayed());
      //  Assert.assertTrue(btnNonLoggedInManageRegistry.isDisplayed());
        Assert.assertTrue(btnCreateARegistry.isDisplayed());
    }

    public void userClickOnFindRegistry(){
        try {
            WaitForMobileElement(btnCreateARegistry);
            ClickOnMobileElement(btnCreateARegistry);
        }catch (Exception e){
            e.printStackTrace();
        }
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
        WaitForMobileElement(btnNext);
        Assert.assertTrue(btnNext.isDisplayed());
   }

   public void userIsOnCreateEventScreen(){
       WaitForMobileElement(btnNext);
        Assert.assertTrue(btnNext.isDisplayed());
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
}
