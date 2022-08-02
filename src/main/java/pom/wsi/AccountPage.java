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
    @iOSXCUITFindBy(id = "HOME")
    private MobileElement homeIcon;
    @iOSXCUITFindBy(accessibility = "MY STORE")
    private MobileElement btnMyStore;
    @iOSXCUITFindBy(accessibility = "DESIGN TOOLS")
    private MobileElement btnDesignTool;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CUSTOMER SERVICE\"]")
    private MobileElement btnCustomerService;
    @iOSXCUITFindBy(accessibility = "SHOPPING PROFILES")
    private MobileElement btnShoppingProfile;
    @iOSXCUITFindBy(accessibility = "MY KEY REWARDS")
    private MobileElement btnMyKeyRewards;
    @iOSXCUITFindBy(id = "START SHOPPING")
    private MobileElement btnStartShopping;
    @iOSXCUITFindBy(accessibility = "ACCOUNT")
    private MobileElement tbrAccount;
    @iOSXCUITFindBy(id = "Choose my preferred store")
    private MobileElement chooseMyPreferredStore;
    @iOSXCUITFindBy(id = "MY ORDERS")
    private MobileElement myOrders;
    @iOSXCUITFindBy(id = "MAKE A DESIGN APPOINTMENT")
    private MobileElement makeAdesignAppoinment;
    @iOSXCUITFindBy(id = "SMART MOODBOARD")
    private MobileElement smartMoodBoard;
    @iOSXCUITFindBy(id = "VIRTUAL ROOM TOUR")
    private MobileElement virtualRoomTour;
    @iOSXCUITFindBy(id = "VIEW IN ROOM")
    private MobileElement viewInRoom;
    @iOSXCUITFindBy(id = "MY KEY REWARDS")
    private MobileElement myKeyRewards;
    @iOSXCUITFindBy(id = "CUSTOMER SERVICE")
    private MobileElement customerService;
    @iOSXCUITFindBy(id = "ACCOUNT SETTINGS")
    private MobileElement accountSettings;
    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    private MobileElement btnAllowWhileUsingApp;

    public void accountDashBoard() {
            scrollTo("","up",btnCustomerService);
            btnCustomerService.isDisplayed();
    }

    public void navigateToAccountSettingPage() {
            waitForMobileElement(btnAccountSetting);
            btnAccountSetting.click();
    }

    public void userInDashBoardScreen() {
            waitForMobileElement(btnAccountSetting);
            Assert.assertTrue(btnAccountSetting.isDisplayed());
    }

    public boolean verifyAllDashboardElements() {
        try {
            makeAdesignAppoinment.isDisplayed();
            smartMoodBoard.isDisplayed();
            virtualRoomTour.isDisplayed();
            viewInRoom.isDisplayed();
            myKeyRewards.isDisplayed();
            customerService.isDisplayed();
            accountSettings.isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean verifyHomePageGetsDisplayed(){
        try{
            clickOnMobileElement(btnStartShopping);
            waitVisibilityOfElement(homeIcon);
            homeIcon.isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }
    }

  public boolean verifyAccountPageGetDisplayed(){
        try {
            clickOnMobileElement(tbrAccount);
            clickOnMobileElement(btnAllowWhileUsingApp);
            waitVisibilityOfElement(myOrders);
            myOrders.isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }
  }
    public void scrollUp() {
        swipeUp();
    }
    public void scrollDown() {
        swipeDown();
    }

}





