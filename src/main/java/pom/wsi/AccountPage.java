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

public class AccountPage extends CommonActions {

    static ExcelReader reader = new ExcelReader();

    public static final Logger logger = LoggerFactory.getLogger(AccountPage.class);

    public AccountPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "setting")
    private MobileElement btnAccountSetting;
    @iOSXCUITFindBy(accessibility = "MY STORE")
    private MobileElement btnMyStore;
    @iOSXCUITFindBy(accessibility = "DESIGN TOOLS")
    private MobileElement btnDesignTool;
    @iOSXCUITFindBy(accessibility = "CUSTOMER SERVICE")
    private MobileElement btnCustomerService;
    @iOSXCUITFindBy(accessibility = "SHOPPING PROFILES")
    private MobileElement btnShoppingProfile;
    @iOSXCUITFindBy(accessibility = "MY KEY REWARDS")
    private MobileElement btnMyKeyRewards;

    public void accountDashBoard() {
        try {
            WaitForMobileElement(btnCustomerService);
            Assert.assertTrue(btnCustomerService.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigateToAccountSettingPage() {
        try {
            swipeUp();
            WaitForMobileElement(btnAccountSetting);
            btnAccountSetting.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userInDashBoardScreen() {
        try {
            WaitForMobileElement(btnAccountSetting);
            Assert.assertTrue(btnAccountSetting.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyAllDashboardElements() {
        try {
            WaitForMobileElement(btnAccountSetting);
            Assert.assertTrue(btnAccountSetting.isDisplayed());
            Assert.assertTrue(btnCustomerService.isDisplayed());
            Assert.assertTrue(btnDesignTool.isDisplayed());
            Assert.assertTrue(btnMyStore.isDisplayed());
            Assert.assertTrue(btnMyKeyRewards.isDisplayed());
            Assert.assertTrue(btnShoppingProfile.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollUp() {
        swipeUp();
    }

    public void scrollDown() {
        swipeDown();
    }


}





