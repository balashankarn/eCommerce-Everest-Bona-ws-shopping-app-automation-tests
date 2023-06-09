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

public class CheckoutPage extends CommonActions {
    static ExcelReader reader = new ExcelReader();
    public static final Logger logger = LoggerFactory.getLogger(CheckoutPage.class);

    public CheckoutPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "CART")
    private MobileElement tbrCart;
    @iOSXCUITFindBy(accessibility = "CHECKOUT")
    private MobileElement btnCheckout;

    @iOSXCUITFindBy(accessibility = "cart_checkout_button")
    private MobileElement btnCheckoutInCart;
    @iOSXCUITFindBy(accessibility = "CHECKOUT AS A GUEST")
    private MobileElement btnCheckoutAsGuest;
    @iOSXCUITFindBy(accessibility = "authentication_sign_in_button")
    private MobileElement btnSignin;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Sign In\"]/XCUIElementTypeButton")
    private MobileElement btnClose;

    public void userClickOnCart() {
        try {
            waitForMobileElement(tbrCart);
            tbrCart.click();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void userLandsOnCheckout() {
        try {
            waitForMobileElement(btnCheckout);
            Assert.assertTrue(btnCheckout.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userIsOnCheckoutPage() {
        try {
            waitForMobileElement(btnCheckout);
            Assert.assertTrue(btnCheckout.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userClickOnCheckOut() {

        try {
            waitForMobileElement(btnCheckout);
            btnCheckout.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void userClickOnCheckOutInCartPage() {

        try {
            waitForMobileElement(btnCheckoutInCart);
            btnCheckoutInCart.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void userLandsonSignInPage() {
        try {
            waitForMobileElement(btnSignin);
            Assert.assertTrue(btnSignin.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userIsOnSignInPage() {
        try {
            waitForMobileElement(btnSignin);
            Assert.assertTrue(btnSignin.isDisplayed());
            Assert.assertTrue(btnCheckoutAsGuest.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void userClicksOnClosebtn() {
        try {
            waitForMobileElement(btnClose);
            Assert.assertTrue(btnClose.isDisplayed());
            btnClose.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userLandsOnCartPage() {

        try {
            waitForMobileElement(btnCheckout);
            Assert.assertTrue(btnCheckout.isDisplayed());
            DriverManager.getDriver().quit();
            // DriverManager.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}