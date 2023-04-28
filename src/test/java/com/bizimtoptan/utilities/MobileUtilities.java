package com.bizimtoptan.utilities;

import io.appium.java_client.*;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class MobileUtilities {

    private static int explicitWait = Integer.parseInt(ConfigurationReader.get("explicitWait"));
    private static int shortExplicitWait = Integer.parseInt(ConfigurationReader.get("explicitWait"));

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeVisible(MobileElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {}

    }

    public static WebElement waitForClickablility(MobileElement element, int timeout) {

        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void slide(double startX, double startY, double endX, double endY, int millis) {

        TouchAction t = new TouchAction(Driver.get());
        t.press(point((int) startX, (int) startY)).waitAction(waitOptions(ofMillis(millis))).moveTo(point((int) endX, (int) endY)).release()
                .perform();
    }


    public static void swipeFullScreenDOWN() {
        Dimension size = Driver.get().manage().window().getSize();
        slide(size.width / 2, size.height - 190, size.width / 2, 50, 1500);
    }
    public static void swipeFullScreenDOWN(int count) {
        Dimension size = Driver.get().manage().window().getSize();
        for (int i = 0; i < count; i++) {
            slide(size.width / 2, size.height - 190, size.width / 2, 50, 1500);
        }
    }

    public static void swipeHalfScreenDOWN() {
        Dimension size = Driver.get().manage().window().getSize();
        slide(size.width / 2, size.height / 2, size.width / 2, 50, 1500);
    }

    public static void swipeQuarterScreenDOWN() {
        Dimension size = Driver.get().manage().window().getSize();
        slide(size.width / 2, size.height / 2.6, size.width / 2.6, 50, 1500);
    }

    public static void swipeFullScreenUP() {
        Dimension size = Driver.get().manage().window().getSize();
        slide(size.width / 2, 400, size.width / 2, size.height - 200, 1500);
    }
    public static void swipeFullScreenUP(int count) {
        Dimension size = Driver.get().manage().window().getSize();
        for (int i = 0; i < count; i++) {
            slide(size.width / 2, 400, size.width / 2, size.height - 200, 1500);
        }
    }

    public static void swipeFullFastScreenUP() {
        Dimension size = Driver.get().manage().window().getSize();
        slide(size.width / 2, 400, size.width / 2, size.height - 100, 500);
    }

    public static void swipeHalfScreenUP() {
        Dimension size = Driver.get().manage().window().getSize();
        slide(size.width / 2, 400, size.width / 2, 500 + size.height / 2, 1500);
    }

    public static void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), explicitWait);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public static void waitForVisibility(MobileElement e, int sec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), sec);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public static void shortWaitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), explicitWait);
        wait.until(ExpectedConditions.visibilityOf(e));
    }


    public static void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), explicitWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }


    public static void waitForVisibility(String text) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), explicitWait);
        By by = MobileBy.xpath("//*[@text='" + text + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForPrecence(By e) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), explicitWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(e));
    }

    public static void waitForPrecence(By e, int w) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), w);
        wait.until(ExpectedConditions.presenceOfElementLocated(e));
    }

    public static void waitForPrecence(String text) {
        By by = By.xpath("//*[@text='" + text + "']");
        WebDriverWait wait = new WebDriverWait(Driver.get(), explicitWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static List<MobileElement> getElement_s(String text) {
        List<MobileElement> elements = Driver.get().findElements(MobileBy.xpath("//*[@text='" + text + "']"));
        return elements;
    }

    public static List<MobileElement> getElement_s(By by) {
        List elements = Driver.get().findElements(by);
        return elements;
    }

    public static void dismissKeyboard(){
        if(!ConfigurationReader.get("phone").equals("RealIphone")){
            Driver.get().hideKeyboard();
        }else {
            if(Driver.get().findElementsByAccessibilityId("Done").size()>0){
                Driver.get().findElementByAccessibilityId("Done").click();
            }else{
                MobileUtilities.touchEmptyElement();
            }
        }
    }

    public static void sendText(MobileElement element, String txt){
        element.click();
        waitFor(2);
        element.sendKeys(txt);
        MobileUtilities.dismissKeyboard();

    }

    public static void sendTextWithCoordinate(MobileElement element, String txt){
        MobileUtilities.getCenterCoordinate(element);
        waitFor(2);
        element.sendKeys(txt);
    }


    public static MobileElement getElementByAccessID(String id) {
        MobileElement elementByAccessibilityId = Driver.get().findElementByAccessibilityId(id);
        return elementByAccessibilityId;
    }

    public static MobileElement getElementName(String name) {
        MobileElement elementNameId = Driver.get().findElementByXPath("//*[@name='"+name+"' and @visible='true']");
        return elementNameId;
    }

    public static MobileElement getElementText(String text) {
        MobileElement elementText = Driver.get().findElementByXPath("//*[@text='"+text+"']");
        return elementText;
    }

    public static void elementFalseScroll(MobileElement element) {
        boolean flag = true;
        int count = 0;
        while (flag) {
            int elementCenterCoordinateY = MobileUtilities.getElementCenterCoordinates(element)[1];
            if (elementCenterCoordinateY < 550 && elementCenterCoordinateY>0) {
                Assert.assertTrue(elementCenterCoordinateY < 550);
                flag = false;
            }
            MobileUtilities.swipeHalfScreenDOWN();
            count = count + 1;
            if (count == 8) {
                flag = false;
            }
        }

    }
    public static void elementFalseScrollXPath(String element, int a) {
        boolean flag = true;
        int count = 0;
        while (flag) {
            int elementCenterCoordinateY = MobileUtilities.getElementCenterCoordinates(Driver.get().findElementByXPath(element))[1];
            if (elementCenterCoordinateY < 550 && elementCenterCoordinateY>0) {
                Assert.assertTrue(elementCenterCoordinateY < 550);
                flag = false;
            }else{
                MobileUtilities.swipeHalfScreenDOWN();
                count = count + 1;
            }

            if (count == a) {
                flag = false;
            }
        }
    }
    public static void elementScroll(MobileElement element) {
        boolean flag = true;
        int count= 0;
        while (flag) {
            try {
                Assert.assertTrue(element.isDisplayed());
                flag = false;
            } catch (Exception e) {
                MobileUtilities.swipeHalfScreenDOWN();
                count= count+1;
                if(count==8){
                    flag=false;
                }
            }
        }
    }

    public static void elementScrollName(MobileElement element) {
        boolean flag = true;
        int count= 0;
        while (flag) {
            try {
                Assert.assertTrue(element.isDisplayed());
                flag = false;
            } catch (Exception e) {
                MobileUtilities.swipeHalfScreenDOWN();
                count= count+1;
                if(count==8){
                    flag=false;
                }
            }
        }
    }

    public static void elementTextScroll(String text) {
        boolean flag = true;
        int count= 0;
        while (flag) {
            try {
                Assert.assertTrue(getElementText(text).isDisplayed());
                flag = false;
            } catch (Exception e) {
                MobileUtilities.swipeHalfScreenDOWN();
                count= count+1;
                if(count==8){
                    flag=false;
                }
            }
        }
    }
    public static void elementXPathScroll(String element) {
        boolean flag = true;
        int count= 0;
        while (flag) {
            try {
                Assert.assertTrue(Driver.get().findElement(By.xpath(element)).isDisplayed());
                flag = false;
            } catch (Exception e) {
                MobileUtilities.swipeHalfScreenDOWN();
                count= count+1;
                if(count==8){
                    flag=false;
                }
            }
        }
    }

    public static void elementUpScroll(String element) {
        boolean flag = true;
        int count= 0;
        while (flag) {
            try {
                Assert.assertTrue(getElementByAccessID(element).isDisplayed());
                flag = false;
            } catch (Exception e) {
                MobileUtilities.swipeFullScreenUP();
                count= count+1;
                if(count==8){
                    flag=false;
                }
            }
        }
    }
    public static MobileElement getElementByIndex(int indexNumber) {
        MobileElement elementByAccessibilityId = Driver.get().findElementByXPath("//*[@index='"+ indexNumber+"']");
        return elementByAccessibilityId;
    }

    public static void clickText(String text) {
        Driver.get().findElement(By.xpath("//*[@text='" + text + "']")).click();
    }

    public static int[] getElementCenterCoordinates(MobileElement element) {
        Point point = element.getCenter();
        int centerX = point.getX();
        int centerY = point.getY();
        return new int[]{centerX, centerY};
    }

    public static void swipeLeft() {
        TouchAction t = new TouchAction(Driver.get());
        t.press(point(900, 700)).waitAction(waitOptions(ofMillis(150))).moveTo(point(100, 700)).release()
                .perform();
    }

    public static void swipeLeftForCampaign(MobileElement element) {
        TouchAction t = new TouchAction(Driver.get());
        t.press(point(280, 160)).waitAction(waitOptions(ofMillis(150))).moveTo(point(50, 160)).release()
                .perform();
        waitFor(2);
        element.click();
        waitFor(2);
        swipeHalfScreenDOWN();
        waitFor(2);
    }

    public static void swipeRight() {
        TouchAction t = new TouchAction(Driver.get());
        Dimension size = Driver.get().manage().window().getSize();
        int coordinate2=size.height/2;
        t.press(point(1, coordinate2)).waitAction(waitOptions(ofMillis(150))).moveTo(point(250, coordinate2)).release()
                .perform();
    }

    public static void getCenterCoordinate(MobileElement element){

        int[] elementCenterCoordinates = MobileUtilities.getElementCenterCoordinates(element);
        MobileUtilities.waitFor(1);
        new TouchAction(Driver.get())
                .press(PointOption.point(elementCenterCoordinates[0],elementCenterCoordinates[1]))
                //.waitAction(WaitOptions.waitOptions(ofSeconds(1)))
                .release().perform();
        MobileUtilities.waitFor(1);

    }

    public static void touch_on_element(int coordinate1,int coordinate2){
        new TouchAction(Driver.get())
                .press(PointOption.point(coordinate1,coordinate2))
                .release().perform();
        MobileUtilities.waitFor(1);
    }

    public static void touchEmptyElement(){
        Dimension size = Driver.get().manage().window().getSize();
        int coordinate1=1;
        int coordinate2=size.height/2;
        new TouchAction(Driver.get())
                .press(PointOption.point(coordinate1,coordinate2))
                .release().perform();
        MobileUtilities.waitFor(1);
    }

}
