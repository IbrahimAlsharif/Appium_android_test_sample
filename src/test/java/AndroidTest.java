
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class AndroidTest {
    public static AppiumDriver driver = null;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app_activity",".ui.actionitem.MainActivity");
        capabilities.setCapability("app_package","jinyoung.dev.todolist");
        String apkPath = "//Users//ibrahimalsharif//IdeaProjects//TodoList//app//build//outputs//apk//debug//app-debug.apk";
        capabilities.setCapability(MobileCapabilityType.APP, apkPath);
        File app = new File(apkPath);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void verifyThatAddTaskButtonIsDisplayed() {
        assertTrue(HomePOM.getAddButton().isDisplayed());
    }

    @Test
    public void verifyThatTappingAddButtonLeadsToShowNewTaskInputPopup() {
        HomePOM.getAddButton().click();
        assertTrue(HomePOM.getNewTaskPopup().isDisplayed());
    }




//    @Test
//    public void test(){
//
//
//
//        MobileElement el3 = (MobileElement) driver.findElementById("jinyoung.dev.todolist:id/etName");
//        el3.sendKeys("Task 01");
//        MobileElement el4 = (MobileElement) driver.findElementById("jinyoung.dev.todolist:id/tvAdd");
//        el4.click();
//        MobileElement el5 = (MobileElement) driver.findElementById("jinyoung.dev.todolist:id/tvName");
//        el5.click();
//
//    }

}
