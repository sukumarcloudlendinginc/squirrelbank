package com.SquirrelBank.constant;

import static java.io.File.separator;

/*	
 * 
 * @Author: Sukumar.Kutagulla
 * 
 */
public interface Path {

	public static final String DEFAULT_LOCATION = System
			.getProperty("user.dir")
			+ separator
			+ "src"
			+ separator
			+ "test"
			+ separator + "resources" + separator;
	public static final String DEFAULT_DATA_PROPERTIES = DEFAULT_LOCATION + "properties" + separator + "data.properties";
	public static final String DEFAULT_PROPERTIES_PATH =  DEFAULT_LOCATION + "properties" + separator+"config.cfg";
	public static final String CHROME_DRIVER_PATH = DEFAULT_LOCATION + "drivers" + separator + "chromedriver.exe";
	public static final String FIREFOX_DRIVER_PATH = DEFAULT_LOCATION + "drivers" + separator + "geckodriver.exe";
	public static final String IE_DRIVER_PATH = DEFAULT_LOCATION + "drivers" + separator + "IEDriverServer.exe";
	public static final String IEEDGE_DRIVER_PATH = DEFAULT_LOCATION + "drivers" + separator + "MicrosoftWebDriver.exe";
}