
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class AndroidTest {
    public static AppiumDriver driver = null;
    private String itemName= "Item 1";
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app_activity",".ui.actionitem.MainActivity");
        capabilities.setCapability("allowTestPackages","true");
        capabilities.setCapability("app_package","jinyoung.dev.todolist");
        String apkPath = "src/app-debug.apk";
        capabilities.setCapability(MobileCapabilityType.APP, apkPath);
        File app = new File(apkPath);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test (priority = 1)
    public void verifyThatAddTaskButtonIsDisplayed() {
        assertTrue(HomePOM.getAddButton().isDisplayed());
    }

    @Test(priority = 2)
    public void verifyThatTappingAddButtonLeadsToShowNewTaskInputPopup() {
        HomePOM.getAddButton().click();
        assertTrue(HomePOM.getNewTaskPopup().isDisplayed());
    }

    @Test(priority = 3)
    public void testAddItem(){
        driver.findElementById("jinyoung.dev.todolist:id/etName").sendKeys(itemName);
        driver.findElementById("jinyoung.dev.todolist:id/tvAdd").click();
        MobileElement newAddedItem = (MobileElement) driver.findElementById("jinyoung.dev.todolist:id/tvName");
        Assert.assertTrue(newAddedItem.isDisplayed());
    }
    @Test(priority = 4)
    public void verifyThatTheAddedItemIsCorrect(){
        MobileElement newAddedItem = (MobileElement) driver.findElementById("jinyoung.dev.todolist:id/tvName");
        Assert.assertEquals(newAddedItem.getText(),itemName);
    }

    @AfterClass
    public void tearDown(){
        if (driver!= null)
            driver.quit();
    }

}
