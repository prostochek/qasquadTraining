package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageFavoriteLgCity {
    public WebDriver driver;
    public WebDriverWait wait;

    public PageFavoriteLgCity(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://lgcity.ru/");
    }

    @FindBy(xpath = "//a[@id=\"menu-342\"]")
    WebElement shoes;

    public void clickShoes() {
        shoes.click();
    }

    @FindBy (id = "menu-341")
    WebElement lowerClothes;

    public void clickLowerClothes() {
        lowerClothes.click();
    }

}


