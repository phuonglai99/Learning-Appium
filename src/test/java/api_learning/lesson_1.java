package api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class lesson_1 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("automationName","uiautomator2");
        desiredCapabilities.setCapability("udid","emulator-5554");
        desiredCapabilities.setCapability("appPackage","com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");

        //Init appium session
        try {
            URL server = new URL("http://localhost:4723/wd/hub");
            driver = new AppiumDriver<MobileElement>(server, desiredCapabilities);

            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
