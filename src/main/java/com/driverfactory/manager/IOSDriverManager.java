package com.driverfactory.manager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.driverfactory.DriverFactory.PlatformList;
import com.driverfactory.DriverFactory.Target;
import com.driverfactory.Factory;
import com.utilities.ConfigReader;

import exceptions.TargetNotValidException;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDriverManager extends Factory {

	private DesiredCapabilities getOptions() throws IOException {
		DesiredCapabilities desiredCapabilities;
		
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getData("iOSdeviceName"));
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getData("iOSPlatformName"));
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getData("iOSVersion"));
		desiredCapabilities.setCapability("udid", ConfigReader.getData("UDID"));
		desiredCapabilities.setCapability("Bundle identifier", ConfigReader.getData("bundleIdentifier"));
		//capabilities.setCapability("noReset", "true");
		desiredCapabilities.setCapability("realMobile", "true");
		desiredCapabilities.setCapability("nativeWebTap","true");
		desiredCapabilities.setCapability("browserstack.networkLogs","true");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getData("iOSAutomationName"));
		desiredCapabilities.setCapability(MobileCapabilityType.APP, ConfigReader.getData("iOSbuildPath"));
		//driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		return desiredCapabilities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IOSDriver<IOSElement> createIOSDriver(Target target) {
		switch (target) {
		case LOCAL:
			URL url = null;
			try {
				url = new URL("http://127.0.0.1:4723/wd/hub");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			try {
				return new IOSDriver<IOSElement>(url, getOptions());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case REMOTE:
			return (IOSDriver<IOSElement>) createRemoteDriver(PlatformList.IOS);
		default:
			throw new TargetNotValidException(target.toString());
		}
	}

}
