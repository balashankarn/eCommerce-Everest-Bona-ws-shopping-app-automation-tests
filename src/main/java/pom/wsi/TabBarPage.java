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

public class TabBarPage  extends CommonActions {
    static ExcelReader reader = new ExcelReader();
    public static final Logger logger = LoggerFactory.getLogger(TabBarPage.class);

    public TabBarPage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    @iOSXCUITFindBy(accessibility ="REGISTRY")
    private MobileElement tbRegistry;
    @iOSXCUITFindBy(accessibility = "HOME")
    private MobileElement tbHome;
    @iOSXCUITFindBy(accessibility = "SHOP")
    private MobileElement tbShop;
    @iOSXCUITFindBy(accessibility = "CART")
    private MobileElement tbCart;




}
