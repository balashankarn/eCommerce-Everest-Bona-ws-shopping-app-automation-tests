package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport extends ConfigReader {
		
		public static void generateReport(String JsonFile) throws IOException {
			
			Configuration config = new Configuration(new File (System.getProperty("user.dir")+"/target/ResultsMobile"), "WSI_AutomationReport");
			config.addClassifications("Platform	","iOS");
//			config.addClassifications("platformVersion",getData("platformVersion"));
//			config.addClassifications("Build", getData("androidBuild"));
			config.addClassifications("deviceName", "iPhone 11");
			config.addClassifications("PKB APP", " 1.0.0");
			List <String> JsonFiles = new ArrayList<String>();
			JsonFiles.add(JsonFile);
			ReportBuilder report = new ReportBuilder(JsonFiles, config);
			report.generateReports();
			 
		}
		

}
