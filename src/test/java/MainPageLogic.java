import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageLogic {

    By loginBtn = By.xpath("//a[@header='header__button ng-star-inserted']");
    By searchInput = By.name("search");
    By findBtn = By.xpath("//button[@class='button button_color_green " +
            "button_size_medium search-form__submit ng-star-inserted']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

        /*String title = "Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине";
        if (!title.equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the main page");
        }*/
    }

    public MainPageLogic typeTextSearchInout(String text) {
        driver.findElement(searchInput).sendKeys(text);
        return this;
    }

    public SearchPageLogic findBtnClick() {
        driver.findElement(findBtn).click();
        return new SearchPageLogic(driver, wait);
    }

    public MainPageLogic loginBtnClick() {
        driver.findElement(loginBtn).click();
        return this;
    }
}
