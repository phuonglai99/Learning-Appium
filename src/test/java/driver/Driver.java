package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Platform.ANDROID;

public class Driver implements MobileCapabilityTypeEx {
    public static AppiumDriver<MobileElement> getDrive(Platform platform) {
        AppiumDriver<MobileElement> drive = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(AUTOMATION_NAME,"uiautomator2");
        desiredCapabilities.setCapability(UDID,"emulator-5554");
        desiredCapabilities.setCapability(APP_PACKAGE,"com.wdiodemoapp");
        desiredCapabilities.setCapability(APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
        URL server = null;
        try {
            server = new URL("http://localhost:4723/wd/hub");
        } catch (Exception e){
            e.printStackTrace();
        }
        
        if(server == null)
            throw new RuntimeException("URL is null");

        switch (platform){
            case IOS:
                drive = new IOSDriver<MobileElement>(server,desiredCapabilities);
                //System.out.println("xuong day khong 1");
                break;
            case ANDROID:
                drive = new AndroidDriver<MobileElement>(server,desiredCapabilities);
                //System.out.println("xuong day khong 2");
                break;
        }
        if(drive!=null) {
            //System.out.println("xuong day khong 3");
            drive.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        return drive;
    }

    public static void main(String[] args) {
        getDrive(ANDROID);
    }
}
