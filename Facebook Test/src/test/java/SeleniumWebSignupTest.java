import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver-win64/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        //
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }


    @Test (priority = 0)
    public void negativeSignup() throws InterruptedException {
            //
            driver.findElement(By.id("user_username")).sendKeys("shindy10");
            //
            driver.findElement(By.id("user_email")).sendKeys("shindy10@mailinator.com");
            //
            driver.findElement(By.id("user_password")).sendKeys("admin");
            //
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void clickUser1Item() throws InterruptedException  {
        //
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/a")).click();
        Thread.sleep(5000);
        //
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {
        //
        driver.quit();
    }
}





