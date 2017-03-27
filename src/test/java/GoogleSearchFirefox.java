import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Travel-user on 3/27/2017.
 */
public class GoogleSearchFirefox {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

        FirefoxDriverManager.getInstance().setup();

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void MyTest() {
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("automated testing");
        driver.findElement(By.name("btnG")).click();
        wait.until(ExpectedConditions.titleIs("automated testing - Пошук Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

