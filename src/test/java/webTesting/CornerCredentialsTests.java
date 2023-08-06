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

public class CornerCredentialsTests extends AuthData{
    public static WebDriver driver;
    AuthData getAuthData = new AuthData();

    private By inputUsername = By.xpath(".//form[@id='login']/div[1]/label/input");
    private By inputPassword = By.xpath(".//form[@id='login']/div[2]/label/input");
    private By btnLogin = By.xpath(".//form[@id='login']/div/button");


    @Test
    public void check2symbolsLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getAuthData.loginUrl);

        driver.findElement(inputUsername).click();
        driver.findElement(inputUsername).sendKeys(getAuthData.fourthLogin);
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(getAuthData.fourthPassword);
        driver.findElement(btnLogin).click();

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath(".//html"));
        String baseURI = element.getAttribute("baseURI");
        Assert.assertEquals(getAuthData.defaultUrl, baseURI);

        WebElement element1 = driver.findElement(By.xpath(".//main/nav/ul/li[3]/a"));
        String welcomeText = element1.getAttribute("text");
        String helloString = "Hello, " + getAuthData.fourthLogin;
        Assert.assertEquals(helloString, welcomeText);

        WebElement element2 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/h2"));
        String title = element2.getAttribute("textContent");
        String expectedTitle = "";
        Assert.assertEquals(expectedTitle, title);

        WebElement element3 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/div"));
        String description = element3.getAttribute("textContent");
        String expectedDescription = "";
        Assert.assertEquals(expectedDescription, description);

        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void check21symbolsLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getAuthData.loginUrl);

        driver.findElement(inputUsername).click();
        driver.findElement(inputUsername).sendKeys(getAuthData.fifthLogin);
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(getAuthData.fifthPassword);
        driver.findElement(btnLogin).click();

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath(".//main/div/div/h1"));
        String statusCode = element.getAttribute("textContent");
        String expectedStatusCode = "500";
        Assert.assertEquals(expectedStatusCode, statusCode);

        WebElement element1 = driver.findElement(By.xpath(".//main/div/div/p"));
        String statusMessage = element1.getAttribute("textContent");
        String expectedMessage = "500: Argument is not a ByteString";
        Assert.assertEquals(expectedMessage, statusMessage);

        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void check20symbolsLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getAuthData.loginUrl);

        driver.findElement(inputUsername).click();
        driver.findElement(inputUsername).sendKeys(getAuthData.sixthLogin);
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(getAuthData.sixthPassword);
        driver.findElement(btnLogin).click();

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath(".//html"));
        String baseURI = element.getAttribute("baseURI");
        Assert.assertEquals(getAuthData.defaultUrl, baseURI);

        WebElement element1 = driver.findElement(By.xpath(".//main/nav/ul/li[3]/a"));
        String welcomeText = element1.getAttribute("text");
        String helloString = "Hello, " + getAuthData.sixthLogin;
        Assert.assertEquals(helloString, welcomeText);

        WebElement element2 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/h2"));
        String title = element2.getAttribute("textContent");
        String expectedTitle = "Family...";
        Assert.assertEquals(expectedTitle, title);

        WebElement element3 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/div"));
        String description = element3.getAttribute("textContent");
        String expectedDescription = "Nothing Stronger Than Family";
        Assert.assertEquals(expectedDescription, description);

        Thread.sleep(5000);

        driver.quit();
    }
    @Test
    public void check3symbolsLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getAuthData.loginUrl);

        driver.findElement(inputUsername).click();
        driver.findElement(inputUsername).sendKeys(getAuthData.seventhLogin);
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(getAuthData.seventhPassword);
        driver.findElement(btnLogin).click();

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath(".//html"));
        String baseURI = element.getAttribute("baseURI");
        Assert.assertEquals(getAuthData.defaultUrl, baseURI);

        WebElement element1 = driver.findElement(By.xpath(".//main/nav/ul/li[3]/a"));
        String welcomeText = element1.getAttribute("text");
        String helloString = "Hello, " + getAuthData.seventhLogin;
        Assert.assertEquals(helloString, welcomeText);

        WebElement element2 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/h2"));
        String title = element2.getAttribute("textContent");
        String expectedTitle = "Кто проживает на дне океана?";
        Assert.assertEquals(expectedTitle, title);

        WebElement element3 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/div"));
        String description = element3.getAttribute("textContent");
        String expectedDescription = "Вы готовы, дети?";
        Assert.assertEquals(expectedDescription, description);

        Thread.sleep(5000);

        driver.quit();
    }
}
