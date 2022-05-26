package com.driverfactory.manager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.driverfactory.DriverFactory.PlatformList;
import com.driverfactory.DriverFactory.Target;
import com.driverfactory.Factory;
import com.utilities.ConfigReader;
import exceptions.TargetNotValidException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndriodDriverManager extends Factory {
	
	
	
	private DesiredCapabilities getOptions() throws IOException {
		DesiredCapabilities desiredCapabilities;
		desiredCapabilities = new DesiredCapabilities();
//		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
//		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel 4");
//	//	desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//		desiredCapabilities.setCapability(MobileCapabilityType.APP, "bs://0ec5b8a9112cce4a80f6ef6d21065d8d058c46ee");
//		
		File f = new File(ConfigReader.getData("buildPath"));
		File fs = new File(f, ConfigReader.getData("androidBuild"));
		desiredCapabilities.setCapability("platformName", ConfigReader.getData("platformName"));
		desiredCapabilities.setCapability("deviceName", ConfigReader.getData("deviceName"));
		desiredCapabilities.setCapability("android Version",ConfigReader.getData("androidVersion"));
//		desiredCapabilities.setCapability("app Package",ConfigReader.getData("appPackage"));
//		desiredCapabilities.setCapability("app Activity", ("appActivity"));
		desiredCapabilities.setCapability("noReset", "true");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,ConfigReader.getData("automationNameAndroid"));
		desiredCapabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
//		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

		return desiredCapabilities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AndroidDriver<AndroidElement> createAndroidDriver(Target target)  {
		switch (target) {
		case LOCAL:
			URL url = null;
			try {
				url = new URL("http://127.0.0.1:4723/wd/hub");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			try {
				return new AndroidDriver<AndroidElement>(url, getOptions());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case REMOTE:
			return (AndroidDriver<AndroidElement>) createRemoteDriver(PlatformList.ANDROID);
		default:
			throw new TargetNotValidException(target.toString());
		}
	}

}
