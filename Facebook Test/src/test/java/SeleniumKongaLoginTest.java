import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;



public class SeleniumKongaLoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        String chromeDriverPath = "resources/chromedriver-win64/chromedriver.exe";
        try {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://www.konga.com/");
        }
        catch (WebDriverException e){
            System.err.println("failed"+ e.getMessage());
        }

    }

    @Test(priority = 1)
    public void positiveLogin() throws InterruptedException {
        //Locate and Click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a"));
        loginButton.click();
        Thread.sleep(5000);
        //Enter valid credentials
        //Enter email address
        WebElement emailField= driver.findElement(By.id("username"));
        emailField.sendKeys("badeloye@gmail.com");
        Thread.sleep(5000);
        //Enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Com_sh#vip2");
        Thread.sleep(5000);
        //Click the login button
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button"));
        signInButton.click();
        Thread.sleep(5000);


    }

    @Test(priority = 2)
    public void navigateToComputersAndAccessories() throws InterruptedException {
        WebElement computersAndAccessories = driver.findElement(By.xpath("//*[@id='nav-bar-fix']/div[2]/div/a[2]"));
        computersAndAccessories.click();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void clickOnLaptops() throws InterruptedException {
        WebElement laptopsCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Laptops']")));
        laptopsCategory.click();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void applyAppleMacBooksFilter() throws InterruptedException {
        WebElement appleFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Apple')]")));
        appleFilter.click();
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void addItemToCart() throws InterruptedException {
        WebElement firstItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[2]/article/div[2]/form/div[2]/button")));
        firstItem.click();
        Thread.sleep(5000);


    }

    @Test(priority = 6)
    public void MyCartAndCheckout() throws InterruptedException {
        //Locate and click on my cart button
        WebElement cartButton =driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]"));
        cartButton.click();
        Thread.sleep(5000);
        //Click on checkout button
        WebElement checkoutButton = driver.findElement(By.xpath("//*[@id='app-content-wrapper']/div[3]/section/section/aside/div[3]/div/div[2]/button"));
        checkoutButton.click();
        Thread.sleep(5000);
    }

    @Test(priority = 7)
    public void continueToPayment() throws InterruptedException {
        //Continue to make payment
        WebElement payNowButton = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input[@value]"));
        payNowButton.click();
        WebElement proceedToPaymentButton = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button"));
        proceedToPaymentButton.click();
        Thread.sleep(10000);

    }

       //8 Select a card payment method
    @Test(priority = 8)
    public void selectCardPaymentMethod () throws InterruptedException {
        //8a Change from default to iframe
        WebElement paymethod = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(7000);
        //8b Select card payment method
        WebElement cardpayment = driver.findElement(By.className("Card"));
             cardpayment.click();
             System.out.println("select card method");
             Thread.sleep(5000);
    }

    @Test(priority = 9)
    public void inputInvalidCardDetails() throws InterruptedException {
        //9 input individual card details
        //9a input card number in its field
        WebElement carddigit = driver.findElement(By.id("card-number"));
        carddigit.sendKeys("4600 1432 7658 9710");
             Thread.sleep(3000);

        //9b Input date in its field
        WebElement datedigit = driver.findElement(By.id("expiry"));
        datedigit.sendKeys("11/25");
        Thread.sleep(3000);

        //9c Input CVV in its field
        WebElement cvvdigit = driver.findElement(By.id("cvv"));
        cvvdigit.sendKeys("711");
        Thread.sleep(5000);
        System.out.println("input card details");
        Thread.sleep(5000);

        WebElement payNowButton = driver.findElement(By.id("validateCardForm"));
        payNowButton.click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void closeBrowser() {
        //Quit browser
        driver.quit();
    }

}



