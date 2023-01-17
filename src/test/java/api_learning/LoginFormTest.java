package api_learning;

import driver.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Platform;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFormTest {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = Driver.getDrive(Platform.ANDROID);
        MobileElement negativeLogin = driver.findElement(MobileBy.AccessibilityId("Login"));

        //open screen Login
        negativeLogin.click();

        //find elements
        MobileElement inputEmail = driver.findElement(MobileBy.AccessibilityId("input-email"));
        MobileElement inputPassword = driver.findElement(MobileBy.AccessibilityId("input-password"));
        MobileElement buttonSubmitLogin = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

        //fill form Login
        inputEmail.sendKeys("phuong@sth.com");
        inputPassword.sendKeys("12345678");
        buttonSubmitLogin.click();

        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver,20);

        //verification
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle"))).getText();
        String content = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/message"))).getText();
        System.out.println(title+" "+content);
    }
}
