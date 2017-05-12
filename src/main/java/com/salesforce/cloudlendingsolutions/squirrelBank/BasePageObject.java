package com.salesforce.cloudlendingsolutions.squirrelBank;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*	
 * 
 * @Author: Sukumar.Kutagulla
 * 
 */
public class BasePageObject {
	static final Logger LOG = LoggerFactory.getLogger(BasePageObject.class);

	// protected static Properties dataProperties;
	protected static Properties config;
	protected static Properties dataConfig;
	public static WebDriver driver = null;
	
	ConfigReader configReader = new ConfigReader();
	
	public String getPropertyValueConfig(String key) {
		return config.getProperty(key);
	}

	public Properties getConfig() throws Exception {
		if (config == null) {
			ConfigReader configReader = new ConfigReader();
			config = configReader.readConfig();
		}
		return config;
	}

	public String getDataPropertyValue(String key) {
		return dataConfig.getProperty(key);
	}

	public static Properties getDataProperties() throws Exception {
		if (dataConfig == null) {
			ConfigReader configReader = new ConfigReader();
			dataConfig = configReader.readDataProperties();
		}
		return dataConfig;
	}

	/*	This method reads the which browser to launch as per the properties
	 * 
	 * @Author: Sukumar.Kutagulla
	 * 
	 */
	public void startDriver() throws Exception {
		getConfig();
		LOG.info("Lanuching the browser ");
		if (config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					configReader.getFireFoxDriverPath());
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					configReader.getChromeDriverPath());
			driver = new ChromeDriver();
		} else if ((config.getProperty("browser").equals("internetExplorer"))) {
			System.setProperty("webdriver.ie.driver",
					configReader.getIEDriverPath());
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.ie.driver",
					configReader.getIEEdgeDriverPath());
			driver = new InternetExplorerDriver();
		}
		driver.get(config.getProperty("baseUrl"));
		driver.manage().window().maximize();
		// WebDriverWait wait=new WebDriverWait(driver, 10);
	}
}
