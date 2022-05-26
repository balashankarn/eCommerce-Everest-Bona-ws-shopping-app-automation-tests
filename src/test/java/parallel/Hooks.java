package parallel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.driverfactory.DriverFactory;
import com.driverfactory.DriverFactory.Target;
import com.driverfactory.DriverManager;
import com.utilities.ConfigReader;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private DriverFactory driverFactory;
	public AppiumDriver driver;
	private ConfigReader configReader;
	Scenario scenario;

	public void launchBrowser() {
		if (driver == null) {
			try {
				String target = configReader.getData("target");
				driverFactory = new DriverFactory();
				driver = driverFactory.getDriver(Target.valueOf(target.toUpperCase()));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				DriverManager.setDriver(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}