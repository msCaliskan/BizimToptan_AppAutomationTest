package com.bizimtoptan.pages;

import com.bizimtoptan.utilities.MobileUtilities;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class CategoryAndProductPage extends BasePage{

    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup") public MobileElement hearthButton_Loc;

    public void clickHearthButton(){
        MobileUtilities.waitForClickablility(hearthButton_Loc,5);
        hearthButton_Loc.click();
        MobileUtilities.waitFor(1);
    }
}
