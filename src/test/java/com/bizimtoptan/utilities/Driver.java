package com.bizimtoptan.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    static AppiumDriver<MobileElement> driver;

    private Driver() {
    }

    public static AppiumDriver<MobileElement> get() {

        if (driver == null) {
         String phone = ConfigurationReader.get("phonee");
            if ("emulator".equals(phone)) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigurationReader.get("automationName"));
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigurationReader.get("platformName"));
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigurationReader.get("platformVersion"));
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationReader.get("deviceName"));
                desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
                desiredCapabilities.setCapability("autoAcceptAlert", true);
                desiredCapabilities.setCapability("autoGrantPermissions", true);
                desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
                desiredCapabilities.setCapability("appPackage", ConfigurationReader.get("appPackage"));
                desiredCapabilities.setCapability("appActivity", ConfigurationReader.get("appActivity"));

                try {
                    driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
                } catch (MalformedURLException e) {
                    System.out.println("Hatalı Url");
                }
            }
        }

        return driver;
    }
    public static void closeDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
