package com.parabank.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

;

public class FileUtils {

	private static final String File_Path = "src/test/resources/testdata/lastRegisteredUser.properties";
	
	public static void  saveUserData(Map<String,String> userData) {
		Properties prop = new Properties();
		prop.putAll(userData);
		
		try(FileOutputStream fos = new FileOutputStream(File_Path)){
			prop.store(fos, "Last Registerd User Data");
			System.out.println("User data saved to lastRegisteredUser.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Load user data back into Map
	public static Properties loadUserData() {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream (File_Path);
			prop.load(fis);
			System.out.println("User data loaded from lastRegisteredUser.properties");
			
		}catch(IOException e) {
			System.out.println("Error loading user data: " + e.getMessage());
		}
		return prop;
	}
}

