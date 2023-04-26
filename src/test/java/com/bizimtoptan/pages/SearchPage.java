package com.bizimtoptan.pages;

import com.bizimtoptan.utilities.MobileUtilities;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//android.widget.EditText") public MobileElement searchBox_Loc;

    public void searchBox(String product){
        MobileUtilities.waitForClickablility(searchBox_Loc,5);
        searchBox_Loc.sendKeys(product+ Keys.ENTER);
        MobileUtilities.waitFor(1);
    }

}
