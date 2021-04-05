package Page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class PageLgCity {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy (id = "menu-326")
    WebElement forMens;

    @FindBy (id = "menu-333")
    WebElement obuff;

    @FindBy (xpath = "//h1[@class = 'title title--h1 catalog__title']")
    WebElement title;

    public PageLgCity(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void open(){
        driver.get("https://lgcity.ru");
    }

    public void clickMens(){
        forMens.click();
    }
    public void clickObuff(){
        obuff.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class = 'title title--h1 catalog__title']")));
        Assert.assertEquals("Мужская обувь", title.getText());
        obuff.sendKeys("111");//бесполезно тут
    }

}
