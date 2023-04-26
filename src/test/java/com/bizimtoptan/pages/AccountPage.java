package com.bizimtoptan.pages;

import com.bizimtoptan.utilities.MobileUtilities;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[2]") public MobileElement nameText_Loc;

    @FindBy(xpath = "//android.widget.TextView[@text='Çıkış Yap']") public MobileElement cikisYapButton_Loc;

    public void getInformation(String name){
        String actualName = nameText_Loc.getText();

        Assert.assertEquals(name, actualName);
    }

    public void clicksCikisButton(){
        MobileUtilities.elementScroll(cikisYapButton_Loc);
        MobileUtilities.waitFor(1);
        cikisYapButton_Loc.click();
        MobileUtilities.waitFor(1);
    }
}
