package parallel;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.driverfactory.DriverFactory;
import com.driverfactory.DriverFactory.Target;
import com.driverfactory.DriverManager;
import com.utilities.ConfigReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Hooks {

	private DriverFactory driverFactory;
	public  AppiumDriver<MobileElement> driver;
	private ConfigReader configReader;
	Scenario scenario;

	public void launchBrowser() {
		if (driver == null) {
			try {
				String target = configReader.getData("target");
				if(target.equalsIgnoreCase("remote")){
					driverFactory = new DriverFactory();
					driver = driverFactory.getDriver(Target.valueOf(target.toUpperCase()));
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					DriverManager.setDriver(driver);
				}
				else if(target.equalsIgnoreCase("local")){
					DesiredCapabilities capabilities = new DesiredCapabilities();
					driverFactory = new DriverFactory();
					capabilities.setCapability("platformName", configReader.getData("platformName"));
					capabilities.setCapability("platformVersion", configReader.getData("platformVersion"));
					capabilities.setCapability("deviceName", configReader.getData("deviceName"));
					capabilities.setCapability("bundleId", configReader.getData("bundleId"));
					capabilities.setCapability("automationName", "XCUITest");
					capabilities.setCapability("waitForQuiescence", "false");
					capabilities.setCapability("--session-override", true);
					capabilities.setCapability("app", System.getProperty("user.dir")+configReader.getData("appPath").trim());
					capabilities.setCapability("newCommandTimeout", 36000);
					driver = new IOSDriver<MobileElement>(new URL("http://" + "127.0.0.1" + ":" + "4723" + "/wd/hub"), capabilities);
					DriverManager.setDriver(driver);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}