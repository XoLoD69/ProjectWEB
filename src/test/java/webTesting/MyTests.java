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


public class MyTests extends AuthData {

    public static WebDriver driver;
    AuthData getAuthData = new AuthData();

    private By inputUsername = By.xpath(".//form[@id='login']/div[1]/label/input");
    private By inputPassword = By.xpath(".//form[@id='login']/div[2]/label/input");
    private By btnLogin = By.xpath(".//form[@id='login']/div/button");


    @Test
    public void createNewPost() throws InterruptedException {

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

        driver.findElement(By.id("create-btn")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("(.//div[@class = 'field']/label/input)[1]")).click();
        driver.findElement(By.xpath("(.//div[@class = 'field']/label/input)[1]")).sendKeys("Hello, my dear friend!");
        driver.findElement(By.xpath("(.//div[@class = 'field']/label/span)[2]/textarea")).click();
        driver.findElement(By.xpath("(.//div[@class = 'field']/label/span)[2]/textarea")).sendKeys("I like you");
        driver.findElement(By.xpath("(.//div[@class = 'field']/label/span)[3]/textarea")).click();
        driver.findElement(By.xpath("(.//div[@class = 'field']/label/span)[3]/textarea")).sendKeys("Do you wanna be my friend?");
        driver.findElement(By.xpath(".//div[@class='submit']/button")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath(".//main/nav/a/span")).click();

        WebElement element = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/img"));
        String imgSrc = element.getAttribute("src");
        String nullImgSrc = getAuthData.defaultUrl + "placeholder/800x600.gif";
        Assert.assertEquals(nullImgSrc, imgSrc);

        System.out.println("actual img source: " + imgSrc);

        WebElement element2 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/h2"));
        String title = element2.getAttribute("textContent");
        String expectedTitle = "Hello, my dear friend!";
        Assert.assertNotNull(title);
        Assert.assertEquals(expectedTitle, title);

        System.out.println("Actual title: " + title);

        WebElement element3 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/div"));
        String description = element3.getAttribute("textContent");
        String expectedDescription = "I like you";
        Assert.assertNotNull(description);
        Assert.assertEquals(expectedDescription, description);

        System.out.println("Actual description: " + description);

        driver.quit();
    }

    @Test
    public void deleteMyNewPost() throws InterruptedException {

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

        driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath(".//div[@class = 'item-card']/div/div/button[2]")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath(".//main/nav/a/span")).click();

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]"));
        String pathname = element.getAttribute("pathname");
        String expectedFirstPostID = "/posts/67770";
        Assert.assertEquals(expectedFirstPostID, pathname);

        WebElement element2 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/h2"));
        String title = element2.getAttribute("textContent");
        String expectedTitle = "Сучётомсложившейсямеждународнойобстановкикурснасоциальноориентированныйнациональныйпроектодиндватрии";
        Assert.assertNotNull(title);
        Assert.assertEquals(expectedTitle, title);

        WebElement element3 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/div"));
        String description = element3.getAttribute("textContent");
        String expectedDescription = "Сучётомсложившейсямеждународнойобстановкикурснасоциальноориентированныйнациональныйпроектодиндватрии";
        Assert.assertNotNull(description);
        Assert.assertEquals(expectedDescription, description);

        driver.quit();
    }

    @Test
    public void orderMyPosts() throws InterruptedException {

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

        driver.findElement(By.xpath(".//div/div/div/div[1]/button")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath(".//div/div/div/div[1]/button")).click();

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]"));
        String pathname = element.getAttribute("pathname");
        String expectedFirstPostID = "/posts/16208";
        Assert.assertEquals(expectedFirstPostID, pathname);

        WebElement element2 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/h2"));
        String title = element2.getAttribute("textContent");
        String expectedTitle = "Hello, world!";
        Assert.assertNotNull(title);
        Assert.assertEquals(expectedTitle, title);

        WebElement element3 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/div"));
        String description = element3.getAttribute("textContent");
        String expectedDescription = "My first message!";
        Assert.assertNotNull(description);
        Assert.assertEquals(expectedDescription, description);

        driver.quit();
    }

    @Test
    public void pageSelector() throws InterruptedException {

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

        driver.findElement(By.xpath(".//div[@class = 'pagination-container svelte-d01pfs']/div/a[2]")).click();

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath(".//html"));
        String secondPageURI = element.getAttribute("baseURI");
        String expectedSecondPageURI = getAuthData.defaultUrl + "?page=2";
        Assert.assertEquals(secondPageURI, expectedSecondPageURI);

        WebElement element1 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/h2"));
        String secondPageTitle = element1.getAttribute("textContent");
        String secondPageExpectedTitle = "Моя милая красотка)";
        Assert.assertNotNull(secondPageTitle);
        Assert.assertEquals(secondPageExpectedTitle, secondPageTitle);

        WebElement element2 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/div"));
        String secondPageDescription = element2.getAttribute("textContent");
        String secondPageExpectedDescription = "Люблю безумно";
        Assert.assertNotNull(secondPageDescription);
        Assert.assertEquals(secondPageExpectedDescription, secondPageDescription);

        driver.findElement(By.xpath(".//div[@class = 'pagination-container svelte-d01pfs']/div/a[1]")).click();

        Thread.sleep(5000);

        WebElement element3 = driver.findElement(By.xpath(".//html"));
        String baseURI = element3.getAttribute("baseURI");
        String expectedBaseURI = getAuthData.defaultUrl + "?page=1";
        Assert.assertEquals(expectedBaseURI, baseURI);

        WebElement element4 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]"));
        String pathname = element4.getAttribute("pathname");
        String expectedFirstPostID = "/posts/67770";
        Assert.assertEquals(expectedFirstPostID, pathname);

        WebElement element5 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/h2"));
        String title = element5.getAttribute("textContent");
        String expectedTitle = "Сучётомсложившейсямеждународнойобстановкикурснасоциальноориентированныйнациональныйпроектодиндватрии";
        Assert.assertNotNull(title);
        Assert.assertEquals(expectedTitle, title);

        WebElement element6 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/div"));
        String description = element6.getAttribute("textContent");
        String expectedDescription = "Сучётомсложившейсямеждународнойобстановкикурснасоциальноориентированныйнациональныйпроектодиндватрии";
        Assert.assertNotNull(description);
        Assert.assertEquals(expectedDescription, description);

        driver.quit();
    }

    @Test
    public void notMyPostsSelector() throws InterruptedException {

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

        driver.findElement(By.id("SMUI-form-field-1")).click();

        Thread.sleep(5000);

        WebElement element1 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/h2"));
        String innerText = element1.getAttribute("innerText");
        String expectedFirstPostText = "Русские пельмени";
        Assert.assertEquals(expectedFirstPostText, innerText);

        WebElement element2 = driver.findElement(By.xpath(".//html"));
        String baseURI = element2.getAttribute("baseURI");
        String expectedBaseURI = getAuthData.defaultUrl + "?owner=notMe&sort=createdAt&order=ASC";
        Assert.assertEquals(expectedBaseURI, baseURI);

        Thread.sleep(5000);

        driver.findElement(By.id("SMUI-form-field-1")).click();

        Thread.sleep(5000);

        WebElement element3 = driver.findElement(By.xpath(".//html"));
        String myBaseURI = element3.getAttribute("baseURI");
        String expectedMyBaseURI = getAuthData.defaultUrl + "?sort=createdAt&order=ASC";
        Assert.assertEquals(myBaseURI, expectedMyBaseURI);

        driver.quit();
    }

    @Test
    public void checkFirstPostContent() throws InterruptedException {

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

        WebElement element = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/img"));
        String imgSrc = element.getAttribute("src");
        String nullImgSrc = getAuthData.defaultUrl + "placeholder/800x600.gif";
        Assert.assertNotEquals(nullImgSrc, imgSrc);

        System.out.println("actual img source: " + imgSrc);

        WebElement element2 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/h2"));
        String title = element2.getAttribute("textContent");
        String expectedTitle = "Сучётомсложившейсямеждународнойобстановкикурснасоциальноориентированныйнациональныйпроектодиндватрии";
        Assert.assertNotNull(title);
        Assert.assertEquals(expectedTitle, title);

        System.out.println("Actual title: " + title);

        WebElement element3 = driver.findElement(By.xpath(".//div[@class = 'content']/div/a[1]/div"));
        String description = element3.getAttribute("textContent");
        String expectedDescription = "Сучётомсложившейсямеждународнойобстановкикурснасоциальноориентированныйнациональныйпроектодиндватрии";
        Assert.assertNotNull(description);
        Assert.assertEquals(expectedDescription, description);

        System.out.println("Actual description: " + description);

        driver.quit();
    }

    @Test
    public void checkAccountWithoutPosts() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getAuthData.loginUrl);

        driver.findElement(inputUsername).click();
        driver.findElement(inputUsername).sendKeys(getAuthData.thirdLogin);
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(getAuthData.thirdPassword);
        driver.findElement(btnLogin).click();

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath(".//div[@class = 'content']/p"));
        String message = element.getAttribute("textContent");
        String expectedMessage = "No items for your filter";
        Assert.assertEquals(expectedMessage, message);

        System.out.println("actual message: " + message);

        driver.quit();
    }
}

