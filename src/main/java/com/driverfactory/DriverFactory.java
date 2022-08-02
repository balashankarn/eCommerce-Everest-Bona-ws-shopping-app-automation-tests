package com.driverfactory;


import com.driverfactory.manager.AndriodDriverManager;
import com.driverfactory.manager.IOSDriverManager;

import io.appium.java_client.AppiumDriver;

public class DriverFactory {
	
	@SuppressWarnings("rawtypes")
	public AppiumDriver getDriver(Target target) {
		AppiumDriver driver = null;
		String platform = System.getProperty("platform");
	//	String platform = "IOS";
		PlatformList platformType = PlatformList.valueOf(platform.toUpperCase());
        switch (platformType) {
            case ANDROID:
                driver = new AndriodDriverManager().createAndroidDriver(target);
                break;
            case IOS:
                driver = new IOSDriverManager().createIOSDriver(target);
                break;
            default:
                break;                    
        }
        return driver;
    }

    public enum PlatformList {
    	ANDROID, IOS
    }
    
    public enum Target {
        LOCAL, REMOTE
    }
	
}
