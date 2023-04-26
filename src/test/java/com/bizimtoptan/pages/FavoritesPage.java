package com.bizimtoptan.pages;

import com.bizimtoptan.utilities.MobileUtilities;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class FavoritesPage extends BasePage{

    @FindBy(xpath = "(//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup)[1]") public MobileElement hearthButton_Loc;

    public void clickHearthButton(){
        MobileUtilities.waitForClickablility(hearthButton_Loc,5);
        hearthButton_Loc.click();
        MobileUtilities.waitFor(1);
    }
}
