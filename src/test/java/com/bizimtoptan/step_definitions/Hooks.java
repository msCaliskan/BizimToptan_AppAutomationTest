package com.bizimtoptan.step_definitions;

import com.bizimtoptan.utilities.Driver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    private AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildDefaultService();


    @Before
    public void setUp(){
        appiumServer.start();
    }


    @After
    public void tearDown(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png","screenshots");
        }
        Driver.closeDriver();
        appiumServer.stop();
    }
}
