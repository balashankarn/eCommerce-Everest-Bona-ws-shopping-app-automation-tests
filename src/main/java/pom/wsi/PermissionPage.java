package pom.wsi;

import com.reusableMethods.CommonActions;
import com.utilities.ExcelReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PermissionPage extends CommonActions {
    static ExcelReader reader = new ExcelReader();
    public static final Logger logger = LoggerFactory.getLogger(PermissionPage.class);

    public PermissionPage(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @iOSXCUITFindBy(accessibility = "Don’t Allow")
    private MobileElement btnDontAllow;
    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    private MobileElement btnAllowWhileUsingApp;
    @iOSXCUITFindBy(accessibility = "Allow Once")
    private MobileElement btnAllowOnce;
    @iOSXCUITFindBy(accessibility = "CONTINUE AS GUEST")
    private MobileElement btnContinueAsGuest;
    @iOSXCUITFindBy(accessibility = "START SHOPPING")
    private MobileElement btnStartShopping;
    @iOSXCUITFindBy(accessibility = "SIGN IN")
    private MobileElement btnSignIn;

    @iOSXCUITFindBy(accessibility = "Allow")
    private MobileElement allowButton;




    public void clickOnAllowOnce() {
        try{
            implicitWait(15);
            btnAllowWhileUsingApp.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void continueShopping(){
        try {
          //  WaitForMobileElement(btnSignIn);
            //ClickOnMobileElement(btnSignIn);
          waitForMobileElement(btnContinueAsGuest);
            clickOnMobileElement(btnContinueAsGuest);
            waitForMobileElement(btnStartShopping);
            clickOnMobileElement(btnStartShopping);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void continueSignIn(){
        try {
            waitForMobileElement(btnSignIn);
            clickOnMobileElement(btnSignIn);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}