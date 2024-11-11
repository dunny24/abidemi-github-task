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
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            System.out.println("Correct Webpage");
        else
            System.out.println("Wrong Webpage");

        Thread.sleep(5000);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void negativeSignupShortUsername() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("shi");
        driver.findElement(By.id("user_email")).sendKeys("shindy44@mailinator.com");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void negativeSignupInvalidEmail() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("shindy44");
        driver.findElement(By.id("user_email")).sendKeys("shindy44@mailinator");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void negativeSignupEmptyFields() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("");
        driver.findElement(By.id("user_email")).sendKeys("");
        driver.findElement(By.id("user_password")).sendKeys("");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void negativeLogin() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("shindy44");
        driver.findElement(By.id("user_email")).sendKeys("shindy44@mailinator.com");
        driver.findElement(By.id("user_password")).sendKeys("#");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void positiveSignup() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("shindy44");
        driver.findElement(By.id("user_email")).sendKeys("shindy44@mailinator.com");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void clickUser1Item() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Correct Webpage");
        else
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test(priority = 6)
    public void verifyItem() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[1]/a")).click();
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            System.out.println("Correct User1page");
        else
            System.out.println("Wrong User1page");
        Thread.sleep(5000);
    }

    @Test(priority = 7)
    public void verifyingItem() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/a")).click();
        String actualPageUrl = driver.getCurrentUrl();
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        if (actualPageUrl.contains(expectedPageUrl))
            System.out.println("Correct User1page");
        else
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void logoutSuccessfully() {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (expectedTitle.contains(actualTitle))
            System.out.println("Correct Webpage");
        else
            System.out.println("Wrong Webpage");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
