package com.bizimtoptan.pages;

import com.bizimtoptan.utilities.ConfigurationReader;
import com.bizimtoptan.utilities.MobileUtilities;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPasswordPage extends BasePage{

    @FindBy(xpath = "//android.widget.EditText") public MobileElement email_Loc;

    public void sendEmail(){
        String email = ConfigurationReader.get("user_email");

        email_Loc.sendKeys(email);
        MobileUtilities.waitFor(1);
    }
}
