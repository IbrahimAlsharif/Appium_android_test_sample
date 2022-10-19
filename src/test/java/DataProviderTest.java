import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Calculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {


   @BeforeClass
    public static void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get("https://www.calculator.net/");
    }


    @DataProvider (name = "testData")
    public Object[][] divisionMethod(){
        return new Object[][] {
                {0.5,0.5,1.0},
                {20,10,2},
                {8,4,2},
                {2,4,0.5}};
    }


    @DataProvider (name = "additionTestData")
    public Object[][] additionMethod(){
        return new Object[][] {
                {0.5,0.5,1.0},
                {20,10,30},
                {8,4,12},
                {2,4,6}};
    }

    @Test (dataProvider = "testData")
    public void testDivisionFunction(double num1, double num2, double expectedResult){
        Calculator calculator= new Calculator();
        Assert.assertEquals(calculator.division(num1,num2),expectedResult);
    }

    @Test (dataProvider = "additionTestData")
    public void testAdditionFunction(double num1, double num2, double expectedResult){
        Calculator calculator= new Calculator();
        Assert.assertEquals(calculator.addition(num1,num2),expectedResult);
    }


   @AfterClass
    void tearDown(){
//        driver.quit();

    }
}
