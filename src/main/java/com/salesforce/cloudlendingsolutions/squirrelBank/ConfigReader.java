package com.salesforce.cloudlendingsolutions.squirrelBank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.SquirrelBank.constant.Path;
/*	
 * 
 * @Author: Sukumar.Kutagulla
 * 
 */
public class ConfigReader {

	private static Properties configFile;
	private static Properties dataProperties;
	private String dataPath = Path.DEFAULT_DATA_PROPERTIES;
	private String path = Path.DEFAULT_PROPERTIES_PATH;
	private String chromePath = Path.CHROME_DRIVER_PATH;
	private String fireFoxPath = Path.FIREFOX_DRIVER_PATH;
	private String IEPath = Path.IE_DRIVER_PATH;
	private String IEEdgePath = Path.IEEDGE_DRIVER_PATH;

	ConfigReader() {
	}

	ConfigReader(String dataPath) {
		this.dataPath = dataPath;
	}

	/*	This method will return config properties
	 * 
	 * @Author: Sukumar.Kutagulla
	 * 
	 */
	public Properties readConfig() throws Exception {
		InputStream istream = getClass().getResourceAsStream(path);
		if (null == istream) {
			try {
				istream = new FileInputStream(path);
			} catch (FileNotFoundException e) {
			}
			if (null == istream)
				throw new Exception("Config file could not be found at " + path);
		}
		configFile = new java.util.Properties(getDefaultProperties());
		try {
			configFile.load(istream);
			istream.close();
		} catch (Exception ex) {
			throw new Exception("Config file could not be found at " + path);
		}
		// resolveCommandLineArgs();
		// resolveVariables();
		return configFile;
	}
	
	/*	This method return dataproperties
	 * 
	 * @Author: Sukumar.Kutagulla
	 * 
	 */
	public Properties readDataProperties() throws Exception {
		InputStream istream = getClass().getResourceAsStream(dataPath);
		if (null == istream) {
			try {
				istream = new FileInputStream(dataPath);
			} catch (FileNotFoundException e) {
			}
			if (null == istream)
				throw new Exception("Config file could not be found at " + dataPath);
		}
		dataProperties = new java.util.Properties(getDefaultProperties());
		try {
			dataProperties.load(istream);
			istream.close();
		} catch (Exception ex) {
			throw new Exception("Config file could not be found at " + dataPath);
		}
		// resolveCommandLineArgs();
		// resolveVariables();
		return dataProperties;
	}

	private Properties getDefaultProperties() {
		Properties def = new Properties();
		def.setProperty("", "");

		return def;
	}
	
	public void setChromeDriver(String chromePath){
		this.chromePath = chromePath;
	}
	
	public String getChromeDriverPath(){
		return chromePath;
	}
	
	public void setFireFoxDriver(String fireFoxPath){
		this.fireFoxPath = fireFoxPath;
	}
	
	public String getFireFoxDriverPath(){
		return fireFoxPath;
	}
	
	public void setIEDriver(String IEPath){
		this.IEPath = IEPath;
	}
	
	public String getIEDriverPath(){
		return IEPath;
	}
	
	public void setIEEDgeDriver(String IEEdgePath){
		this.IEEdgePath = IEEdgePath;
	}
	
	public String getIEEdgeDriverPath(){
		return IEEdgePath;
	}
}
