package com.bizimtoptan.pages;

import com.bizimtoptan.utilities.ConfigurationReader;
import com.bizimtoptan.utilities.MobileUtilities;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//android.widget.EditText") public MobileElement email_Loc;

    @FindBy(xpath = "//android.widget.EditText[2]") public MobileElement password_Loc;

    public void login(){
        String email = ConfigurationReader.get("user_email");
        String password = ConfigurationReader.get("user_password");

        email_Loc.sendKeys(email);
        password_Loc.sendKeys(password);
        MobileUtilities.waitFor(1);
    }
    public void invalidLogin(){

        email_Loc.sendKeys("musainveonn@gmail.com");
        password_Loc.sendKeys("Inveon34..");
        MobileUtilities.waitFor(1);
    }

}
