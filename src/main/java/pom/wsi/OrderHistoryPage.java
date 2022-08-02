package pom.wsi;

import com.driverfactory.DriverManager;
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

public class OrderHistoryPage extends CommonActions {
    static ExcelReader reader = new ExcelReader();
    public static final Logger logger = LoggerFactory.getLogger(CheckoutPage.class);

    public OrderHistoryPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "ACCOUNT")
    private MobileElement btnAccountPage;

    @iOSXCUITFindBy(accessibility = "ORDER HISTORY")
    private MobileElement btnOrderHistory;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Order History\"])[2]")
    private MobileElement textOrderHistory;

    @iOSXCUITFindBy(accessibility = "Search By Order #")
    private  MobileElement textSearchByOrder;

    public void accountPage(){
        try {
            waitForMobileElement(btnAccountPage);
            Assert.assertTrue(btnAccountPage.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void accountPageButtonClick(){
        try {
            clickOnMobileElement(btnAccountPage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void accountPageClickOrderHistory(){
        try {
            waitForMobileElement(btnOrderHistory);
            Assert.assertTrue(btnOrderHistory.isDisplayed());
            clickOnMobileElement(btnOrderHistory);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

   public void userIsInOrderHistoryPage(){
       try {
           waitForMobileElement(textOrderHistory);
           Assert.assertTrue(textOrderHistory.isDisplayed());
           waitForMobileElement(textSearchByOrder);
           Assert.assertTrue(textSearchByOrder.isDisplayed());
           DriverManager.getDriver().quit();
       }catch (Exception e){
           e.printStackTrace();
       }
   }

}
