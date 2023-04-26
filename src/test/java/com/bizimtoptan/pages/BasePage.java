package com.bizimtoptan.pages;

import com.bizimtoptan.utilities.Driver;
import com.bizimtoptan.utilities.MobileUtilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator((Driver.get())), this);
    }

    public static void clickButton(String button){
        String button_Loc = "//android.widget.TextView[@text='"+button+"']";
        try{
            MobileElement element= Driver.get().findElement(By.xpath(button_Loc));
            MobileUtilities.waitForClickablility(element,5);
            element.click();
            MobileUtilities.waitFor(2);
        }catch (Exception e){
            MobileUtilities.waitFor(1);
        }
    }

    public static String verifyMessage(String msg){
        MobileUtilities.waitFor(2);
        String msg_Loc = Driver.get().findElement(By.xpath("//android.widget.TextView[@text='"+msg+"']")).getText();

        return msg_Loc;
    }
}
