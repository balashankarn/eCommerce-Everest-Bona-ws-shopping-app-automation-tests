package com.driverfactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.driverfactory.DriverFactory.PlatformList;
import com.driverfactory.DriverFactory.Target;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public abstract class  Factory {

	protected IOSDriver<IOSElement> createIOSDriver(Target target) {
		return null;
		
	}

	protected AndroidDriver<AndroidElement> createAndroidDriver(Target target) {
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected AppiumDriver createRemoteDriver(PlatformList platform) {
		JSONParser parser = new JSONParser();
		JSONObject config = null;
		try {
			config = (JSONObject) parser
					.parse(new FileReader("src/test/resources/com/browserstack/run_parallel_test/parallel.conf.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray envs = (JSONArray) config.get("environments");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		
//		Map<String, String> envCapabilities = (Map<String, String>) envs
//				.get(1);
		
		Map<String, String> envCapabilities = (Map<String, String>) envs
				.get(Integer.parseInt(System.getProperty("deviceIndex")));

		Iterator it = envCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
		}

		Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
		it = commonCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (capabilities.getCapability(pair.getKey().toString()) == null) {
				capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
			}
		}

		String username = System.getenv("BROWSERSTACK_USERNAME");
		if (username == null) {
			username = (String) config.get("username");
		}

		String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		if (accessKey == null) {
			accessKey = (String) config.get("access_key");
		}

		String app = System.getenv("BROWSERSTACK_APP_ID");
		if (app != null && !app.isEmpty()) {
			capabilities.setCapability("app", app);
		}
		
		capabilities.setCapability("autoAcceptAlerts", true);
		switch (platform) {

		case ANDROID:
			try {
				return new AndroidDriver<AndroidElement>(
						new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"),
						capabilities);
			
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case IOS:
			try {
				return new IOSDriver<IOSElement>(
						new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"),
						capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		default:
			break;
		}

		return null;

	}

}
