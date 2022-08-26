package com.reusableMethods;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driverfactory.DriverManager;
import com.google.common.collect.ImmutableMap;
import com.utilities.ExcelReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class CommonActions {
    public static String platformName = null;
    public static Properties props;
    public static Logger logger = Logger.getLogger(String.valueOf(CommonActions.class));
    //public static RemoteWebDriver driver = DriverManager.getDriver();
    public static AppiumDriver<MobileElement> driver = DriverManager.getDriver();
    public static String ConfigurationFile = System.getProperty("user.dir") + "/Configs/Configuration.properties";
    public static WebElement element = null;
    public static String mainWindow = null;
    static WebDriverWait browserWithElementWait = null;
    static Date date = java.util.Calendar.getInstance().getTime();
    public static WebDriverWait exwait = null;
    ExcelReader reader = new ExcelReader();

    static {
        try {
            platformName = getData("platformName");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CommonActions() {
        try {
            exwait = new WebDriverWait(DriverManager.getDriver(), 100);
        } catch (Exception e) {
        }
    }

    public static String getData(String data) throws IOException {
        loadData();
        data = props.getProperty(data);
        return data;
    }

    public static void loadData() throws IOException {
        props = new Properties();
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
        FileReader fileInput = new FileReader(file);
        props.load(fileInput);
    }

    public static boolean fluentWaitDisplayed(MobileElement element, long t, long ts) {
        try {
            FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(t))
                    .pollingEvery(Duration.ofMillis(ts)).ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isToastMessageDisplayed(String message) {
        boolean isDisplayed = false;
        int count = 0;
        do {
            if (DriverManager.getDriver().getPageSource().contains(message)) {
                isDisplayed = true;
                break;
            }
            count++;
        } while (count < 10);
        return isDisplayed;
    }

    public static void keyBoardSearch() {
        DriverManager.getDriver().executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));

    }

    public static void androidKeyBack() {
        ((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public static void swipeDown() {

        Dimension dimension = DriverManager.getDriver().manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.5);
        int scrollEnd = (int) (dimension.getHeight() * 0.2);
        new TouchAction((PerformsTouchActions) DriverManager.getDriver()).press(point(0, scrollStart))
                .waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(0, scrollEnd))
                .release().perform();
    }

    public static void scrollAndClick(By listItems, String Text) throws InterruptedException {
        boolean flag = false;
        while (true) {
            for (WebElement el : driver.findElements(listItems)) {
                if (el.getText().equals(Text)) {
                    el.click();
                    flag = true;
                    break;
                } else {
                    swipeDown();
                }
            }
        }
    }

    public static void horizontalSwipe(List<MobileElement> e) {
        MobileElement firdelement = e.get(0);
        MobileElement secondElement = e.get(1);
        MobileElement thirdElement = e.get(2);

        int midOfY = thirdElement.getLocation().y + (thirdElement.getSize().height / 2);
        int fromXLocation = thirdElement.getLocation().x;
        int toXLocation = firdelement.getLocation().x;

        TouchAction action = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
        action.press(point(fromXLocation, midOfY))
                .waitAction(waitOptions(Duration.ofSeconds(3)))
                .moveTo(point(toXLocation, midOfY)).release().perform();

    }

    public static void horizontalSwipeAndriod(List<MobileElement> e) {

        MobileElement firdelement = e.get(0);
        MobileElement secondElement = e.get(1);
        int midOfY = secondElement.getLocation().y + (secondElement.getSize().height / 2);
        int fromXLocation = secondElement.getLocation().x;
        int toXLocation = firdelement.getLocation().x;
        TouchAction action = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
        action.press(point(fromXLocation, midOfY))
                .waitAction(waitOptions(Duration.ofSeconds(3)))
                .moveTo(point(toXLocation, midOfY)).release().perform();

    }

    public static boolean hidemobileKeyboard(AndroidDriver app) {
        boolean isKeyboardHideResult = false;
        try {
            app.hideKeyboard();
            isKeyboardHideResult = true;
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return isKeyboardHideResult;
    }


    public boolean isElementPresent(WebElement e) {
        waitFor(5000);
        boolean flag = true;
        try {
            e.isDisplayed();
            flag = true;
        } catch (Exception a) {
            flag = false;
        }
        return flag;
    }

    public static void takeScreenshot(WebDriver driver, String filename) throws IOException {
        waitFor(2000);
        File sc = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sc, new File(filename));
    }

    public static void hideMobileKeyboard() {
        if (platformName.equalsIgnoreCase("android")) {
            hidemobileKeyboard((AndroidDriver) driver);
        } else {
            int isPresent = DriverManager.getDriver().findElements(By.xpath("//XCUIElementTypeButton[@name='Done']")).size();
            if (isPresent == 1) {
                DriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='Done']")).click();
            }
        }
    }

    public void scrollTo(String Scroll, String direction, MobileElement element) {
        if ("ANDROID".equalsIgnoreCase(platformName)) {
            DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(" + Scroll
                            + ").instance(0))"));
            waitFor(1000);
        } else if ("IOS".equalsIgnoreCase(platformName)) {
            for (int i = 0; i < 5; i++) {
                boolean isElementPresent = element.isDisplayed();
                if (!isElementPresent) {
                    Map<String, Object> args = new HashMap<>();
                    args.put("direction", direction);
                    DriverManager.getDriver().executeScript("mobile: swipe", args);
                } else {
                    break;
                }
            }
        }
    }

    public void scrollToMobileElement(String Scroll) {
        MobileElement element = (MobileElement) DriverManager.getDriver().findElement(
                MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).instance(0)"
                        + ".scrollIntoView(new UiSelector().text(" + Scroll + "))"));
        waitFor(1000);
        element.click();
    }

    public static void waitFor(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isSelected(MobileElement e) {
        boolean b = e.isSelected();
        return b;
    }

    public static boolean isEnabled(MobileElement e) {
        boolean result = e.isEnabled();
        return result;
    }

    public static boolean isDisplayed(MobileElement e) {
        boolean d = e.isDisplayed();
        return d;
    }

    public static int generateRandomNumber() {
        Random rand = new Random();
        int randNumber = rand.nextInt(100000);
        return randNumber;

    }

    public String randomStringGenerate() {
        return RandomStringUtils.randomAlphanumeric(20);
    }

    public static void highlightElement(WebElement element, WebDriver webDriver) {
        for (int i = 0; i < 1; i++) {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                    "color: black; border: 3px solid black;");
        }
    }

    public static String getMainWindow() throws Throwable {
        String mainWindow = null;
        try {
            mainWindow = DriverManager.getDriver().getWindowHandle();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mainWindow;
    }

    public static void switchToMainWindow() throws Throwable {
        // killChromeSession();
        try {
            DriverManager.getDriver().switchTo().window(mainWindow);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void switchToNewWindow() throws Throwable {
        try {
            Set<String> windowNames = DriverManager.getDriver().getWindowHandles();
            for (String windowName : windowNames) {

                if (windowName != null) {
                    DriverManager.getDriver().switchTo().window(windowName);
                } else {
                    throw new Exception("New window could not be retrived");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String randomStringGenerate(int count) {

        return RandomStringUtils.randomAlphanumeric(count);

    }

    public static void javascriptScroll(WebElement element) {
        waitFor(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: lightskyblue; border: 2px solid red;');", element);
        waitFor(2000);
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public static void swipeUp() {

        Dimension dimension = DriverManager.getDriver().manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.20);
        int scrollEnd = (int) (dimension.getHeight() * 0.80);
        new TouchAction((PerformsTouchActions) driver).press(point(2, scrollStart))
                .waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(2, scrollEnd))
                .release().perform();
    }

    public static void swipeleft(MobileElement e) {
        Dimension dimension = DriverManager.getDriver().manage().window().getSize();
        int scrollStart = (int) (dimension.getWidth() * 0.8);
        int scrollEnd = (int) (dimension.getWidth() * 0.4);
        int y = (int) (dimension.getHeight() / 2);
        new TouchAction((PerformsTouchActions) driver).press(point(scrollStart, y))
                .waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(scrollEnd, y))
                .release().perform();
    }


    public static void clickOnMobileElement(MobileElement element) {
        waitVisibilityOfElement(element);
        boolean status = true;
        for (int i = 0; i < 10; i++) {

            try {
                waitFor(1000);
                element.click();
                status = true;
                break;
            } catch (Exception e) {

                status = false;
                waitFor(1000);
            }
        }

        Assert.assertTrue(status);
    }

    public static void sendKeysOnMobileElement(MobileElement element, String Value) {
        waitVisibilityOfElement(element);
        // element.clear();
        element.sendKeys(Value);
    }

    public static void sendKeysOnMobileElementList(MobileElement mobileElement, String value) {
        waitVisibilityOfElement(mobileElement);
        mobileElement.sendKeys();
        element.sendKeys(value);
    }

    public static void sendKeysWithoutClear(MobileElement mobileElement, String Value) {
        waitVisibilityOfElement(mobileElement);
        mobileElement.sendKeys(Value);
    }

    public static boolean waitForMobileElement(MobileElement element) {
        waitVisibilityOfElement(element);
        return true;
    }

    public static void waitForMobileElementList(List<MobileElement> title_MoreOptions) {
        exwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) title_MoreOptions));

    }

    public static void touchActionClick(MobileElement element) throws InterruptedException {
        MobileElement mobelement = (MobileElement) exwait.until(ExpectedConditions.visibilityOf(element));
        TouchActions act = new TouchActions(DriverManager.getDriver());
        act.click(mobelement).build().perform();

    }

    public static boolean isDisplayedMobileElement(MobileElement element) {
        MobileElement mobelement = (MobileElement) exwait.until(ExpectedConditions.visibilityOf(element));
        return mobelement.isDisplayed();

    }

    public static void changeDriverContextToWeb(AppiumDriver driver) {
        Set<String> allContext = DriverManager.getDriver().getContextHandles();
        for (String context : allContext) {
            if (context.contains("WEBVIEW"))
                DriverManager.getDriver().context(context);
        }
    }

    public static void changeDriverContextToNative(AppiumDriver driver) {
        Set<String> allContext = DriverManager.getDriver().getContextHandles();
        for (String context : allContext) {
            if (context.contains("NATIVE"))
                DriverManager.getDriver().context(context);
        }

    }

    public void iosButtonClick(String string) {
        waitFor(6000);
        MobileElement element = (MobileElement) driver
                .findElementByXPath("//XCUIElementTypeButton[@name='" + string + "']");
        element.click();
    }

    public static void ClickUsingXandYCords(MobileElement element) {
        waitFor(3000);
        Point point = element.getLocation();
        int xcord = point.getX();
        int ycord = point.getY();
        new TouchAction((PerformsTouchActions) DriverManager.getDriver()).tap(point(xcord, ycord)).perform();
    }

    public static void MobDragAndDrop(MobileElement element1, MobileElement element2) {
        Actions act = new Actions(driver);
        act.clickAndHold(element1).moveToElement(element2).release().build().perform();

    }

    public static void touchCenter() {
        Dimension dimension = DriverManager.getDriver().manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.20);
        int scrollEnd = (int) (dimension.getHeight() * 0.50);
        new TouchAction((PerformsTouchActions) driver).press(point(2, scrollStart))
                .waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(2, scrollEnd))
                .release().perform();
    }

    public static void navBack() {
        ((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }


    public static void jsClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement webelement = wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: lightskyblue; border: 2px solid red;');", webelement);
        waitFor(2000);
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", webelement, "");
        js.executeScript("arguments[0].click();", webelement);
    }

    public static void switchToIframe(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement webelement = wait.until(ExpectedConditions.visibilityOf(element));
        DriverManager.getDriver().switchTo().defaultContent();
        DriverManager.getDriver().switchTo().frame(webelement);
    }

    public void quitBrowser() {
        driver.closeApp();
    }

    public void swipeScreen(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 2000; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = DriverManager.getDriver().manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        //
        try {
            new TouchAction(DriverManager.getDriver())
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    public void implicitWait(int waitTime) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static WebDriverWait webDriverWait() {
        return new WebDriverWait(driver, 20);
    }

    public static void waitVisibilityOfElement(MobileElement element) {
        webDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void doubleClickOnElement(MobileElement element) {
        Actions act = new Actions(driver);
        act.doubleClick(element).click().build().perform();
    }

    public void scrollByPercentage(double startX, double startY, double endY) {
        waitFor(2000);
        Dimension size = driver.manage().window().getSize();
        int startX1 = (int) (size.width * startX);
        int startY1 = (int) (size.height * startY);
        int endY1 = (int) (size.height * endY);
        new TouchAction((PerformsTouchActions) driver).press(point(startX1, startY1)).waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(point(startX1, endY1)).release().perform();
    }

    public String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(date);
        return str;
    }

    public String getNextDay() {
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.add(Calendar.DATE, 1);

        Date d1 = c.getTime();

        int nextDay = Integer.parseInt(dateFormat.format(d1));
        return Integer.toString(nextDay);

    }

    public void moveToElementAndClick(MobileElement element) {
        waitVisibilityOfElement(element);
        Actions act = new Actions(driver);
        act.moveToElement(element).click().perform();
    }

    public void scrollByXYcordinates(int startX, int startY, int endX, int endY) {

        Dimension size = driver.manage().window().getSize();

        new TouchAction((PerformsTouchActions) driver).press(point(startX, startY)).waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(point(endX, endY)).release().perform();

    }

    public void scrollDown() {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "up");
        driver.executeScript("mobile: swipe", args);
    }

    public void scrollUp() {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "down");
        driver.executeScript("mobile: swipe", args);
    }

}






