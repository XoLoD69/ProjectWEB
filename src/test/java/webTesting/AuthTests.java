package webTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AuthTests extends AuthData {
    public static WebDriver driver;
    AuthData getAuthData = new AuthData();

    private By inputUsername = By.xpath(".//form[@id='login']/div[1]/label/input");
    private By inputPassword = By.xpath(".//form[@id='login']/div[2]/label/input");
    private By btnLogin = By.xpath(".//form[@id='login']/div/button");

    @Test
    public void positiveAuthorization() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getAuthData.loginUrl);

        driver.findElement(inputUsername).click();
        driver.findElement(inputUsername).sendKeys(getAuthData.firstLogin);
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(getAuthData.firstPassword);
        driver.findElement(btnLogin).click();

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath(".//html"));
        String baseURI = element.getAttribute("baseURI");
        Assert.assertEquals(getAuthData.defaultUrl, baseURI);

        WebElement element1 = driver.findElement(By.xpath(".//main/nav/ul/li[3]/a"));
        String welcomeText = element1.getAttribute("text");
        String helloString = "Hello, " + getAuthData.firstLogin;
        Assert.assertEquals(helloString, welcomeText);

        WebElement element2 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]"));
        String pathname = element2.getAttribute("pathname");
        String expectedFirstPostID = "/posts/67770";
        Assert.assertEquals(expectedFirstPostID, pathname);

        System.out.println("Hello message: " + welcomeText);
        System.out.println("Actual URL: " + baseURI);

        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void negativeAuthorization() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getAuthData.loginUrl);

        driver.findElement(inputUsername).click();
        driver.findElement(inputUsername).sendKeys(getAuthData.secondLogin);
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(getAuthData.secondPassword);
        driver.findElement(btnLogin).click();

        WebElement element3 = driver.findElement(By.xpath(".//div/div[2]/h2"));
        String errorCode = element3.getAttribute("innerText");
        String actualCode = "401";

        WebElement element4 = driver.findElement(By.xpath(".//div/div[2]/p[1]"));
        String errorText = element4.getAttribute("innerText");
        String message = "Invalid credentials.";

        WebElement element5 = driver.findElement(By.xpath(".//html"));
        String baseURI1 = element5.getAttribute("baseURI");
        String loginURI1 = getAuthData.loginUrl;

        Assert.assertEquals(actualCode, errorCode);
        Assert.assertEquals(message, errorText);
        Assert.assertEquals(baseURI1, loginURI1);

        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void logout() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getAuthData.loginUrl);

        driver.findElement(inputUsername).click();
        driver.findElement(inputUsername).sendKeys(getAuthData.firstLogin);
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(getAuthData.firstPassword);
        driver.findElement(btnLogin).click();

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath(".//html"));
        String baseURI = element.getAttribute("baseURI");
        Assert.assertEquals(getAuthData.defaultUrl, baseURI);

        WebElement element1 = driver.findElement(By.xpath(".//main/nav/ul/li[3]/a"));
        String welcomeText = element1.getAttribute("text");
        String helloString = "Hello, " + getAuthData.firstLogin;
        Assert.assertEquals(helloString, welcomeText);

        WebElement element2 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]"));
        String pathname = element2.getAttribute("pathname");
        String expectedFirstPostID = "/posts/67770";
        Assert.assertEquals(expectedFirstPostID, pathname);


        driver.findElement(By.xpath(".//main/nav/ul/li[3]")).click();

        driver.findElement(By.xpath(".//main/nav/ul/li[3]/div/ul/li[3]")).click();

        Thread.sleep(5000);


        WebElement element3 = driver.findElement(By.xpath(".//html"));
        String baseURI1 = element3.getAttribute("baseURI");
        String loginURI1 = getAuthData.loginUrl;
        Assert.assertEquals(loginURI1, baseURI1);

        driver.quit();

    }
}
