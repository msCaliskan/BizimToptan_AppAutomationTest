package com.bizimtoptan.pages;

import com.bizimtoptan.utilities.MobileUtilities;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Ana Sayfa']") public MobileElement anaSayfaText_Loc;

    public void gotoHomePage() {
        String expectedTitle = "Ana Sayfa";
        MobileUtilities.waitForElementToBeVisible(anaSayfaText_Loc, 60);
        String actualTitle = anaSayfaText_Loc.getText();

        Assert.assertEquals(expectedTitle, actualTitle);

    }

}
