import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lesson_25 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void pageObject() {
        new MainPageLogic(driver, wait).typeTextSearchInout("Mac").findBtnClick();

        SearchPageLogic searchPageLogic = new SearchPageLogic(driver, wait);

        String title = searchPageLogic.firstProductTitleText();
        System.out.println(title);

        searchPageLogic.firstProductClick();
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
