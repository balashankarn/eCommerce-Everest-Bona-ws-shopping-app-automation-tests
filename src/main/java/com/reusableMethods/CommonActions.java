package com.reusableMethods;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
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

public class CommonActions {
	public static String platformName = null;
	public static Properties props;
	public static Logger logger = Logger.getLogger(String.valueOf(CommonActions.class));
	public static RemoteWebDriver driver=DriverManager.getDriver();
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
		new TouchAction((PerformsTouchActions) DriverManager.getDriver()).press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
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
		action.press(PointOption.point(fromXLocation, midOfY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(toXLocation, midOfY)).release().perform();

	}

	public static void horizontalSwipeAndriod(List<MobileElement> e) {

		MobileElement firdelement = e.get(0);
		MobileElement secondElement = e.get(1);
		int midOfY = secondElement.getLocation().y + (secondElement.getSize().height / 2);
		int fromXLocation = secondElement.getLocation().x;
		int toXLocation = firdelement.getLocation().x;
		TouchAction action = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
		action.press(PointOption.point(fromXLocation, midOfY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(toXLocation, midOfY)).release().perform();

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
	
	
	public boolean isElementPresent(WebElement e)
    {
        waitFor(5000);
        boolean flag=true;
        try {
            e.isDisplayed();
            flag=true;
        }
        catch(Exception a)
        {
            flag=false;
        }
        return flag;
    }
	public static void takeScreenshot(WebDriver driver, String filename) throws IOException
	{
		waitFor(2000);
		File sc = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
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

	public void ScrollTo(String Scroll, String direction, MobileElement element) {
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

	public void ScrollToMobileElement(String Scroll) {
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

	public static int  generateRandomNumber()
	{
		Random rand = new Random();
		int randNumber = rand.nextInt(100000);
		return randNumber;
		
	}

	public String RandomStringGenerate() {
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

	public static String RandomStringGenerate(int count) {

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
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(2, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(2, scrollEnd))
				.release().perform();
	}

	public static void swipeleft(MobileElement e) {
		Dimension dimension = DriverManager.getDriver().manage().window().getSize();
		int scrollStart = (int) (dimension.getWidth() * 0.8);
		int scrollEnd = (int) (dimension.getWidth() * 0.4);
		int y = (int) (dimension.getHeight() / 2);
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(scrollStart, y))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(scrollEnd, y))
				.release().perform();
	}
	

	public static void ClickOnMobileElement(MobileElement element) {
		MobileElement mobelement = (MobileElement) exwait.until(ExpectedConditions.visibilityOf(element));
		waitFor(2000);
		mobelement.click();
	}

	public static void SendKeysOnMobileElement(MobileElement element, String Value) {
		MobileElement mobelement = (MobileElement) exwait.until(ExpectedConditions.visibilityOf(element));
		mobelement.clear();
		mobelement.sendKeys(Value);
	}

	public static void SendKeysOnMobileElementList(MobileElement mobileElement, String Value) {
		MobileElement mobelement = (MobileElement) exwait
				.until(ExpectedConditions.visibilityOf((WebElement) mobileElement));
		// mobelement.clear();
		mobelement.sendKeys(Value);
	}

	public static void SendKeysWithoutClear(MobileElement element, String Value) {
		MobileElement mobelement = (MobileElement) exwait.until(ExpectedConditions.visibilityOf(element));
		mobelement.sendKeys(Value);
	}

	public static void WaitForMobileElement(MobileElement element) {
		exwait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void WaitForMobileElementList(List<MobileElement> title_MoreOptions) {
		exwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) title_MoreOptions));

	}

	public static void TouchActionClick(MobileElement element) throws InterruptedException {
		MobileElement mobelement = (MobileElement) exwait.until(ExpectedConditions.visibilityOf(element));
		TouchActions act = new TouchActions(DriverManager.getDriver());
		act.click(mobelement).build().perform();

	}

	public static boolean IsDisplayedMobileElement(MobileElement element) {
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

	public void IosButtonClick(String string) {
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
		new TouchAction((PerformsTouchActions)DriverManager.getDriver()).tap(PointOption.point(xcord, ycord)).perform();
	}

public static void MobDragAndDrop(MobileElement element1, MobileElement element2) {
	Actions act = new Actions(driver);
	act.clickAndHold(element1).moveToElement(element2).release().build().perform();

	}
	
	public static void touchCenter() {
		Dimension dimension = DriverManager.getDriver().manage().window().getSize();
		int scrollStart = (int) (dimension.getHeight() * 0.20);
		int scrollEnd = (int) (dimension.getHeight() * 0.50);
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(2, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(2, scrollEnd))
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
	
}
