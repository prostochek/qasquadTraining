package Page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PagePoiskLgCity {
    WebDriver driver;
    WebDriverWait wait;

    public PagePoiskLgCity(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void open(){
        driver.get("https://lgcity.ru");
    }

    @FindBy (xpath = "//a[@class='header__r-icons-link header__r-icons-link--search js-popup']")
    WebElement lupa;
    @FindBy (xpath ="//input[@name = 'q']")
    WebElement vvodvpoisk;
    @FindBy (xpath = "//button[@class = 'header__search-button']")
    WebElement lupa2;
    @FindBy (className = "catalog__item-desc")
    WebElement card1;
    @FindBy (className = "catalog__subtitle")
    WebElement koli4estvo;

    public void search(String tek) {
        lupa.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Что вы хотите найти?')]")));
        vvodvpoisk.sendKeys(tek);
        lupa2.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'catalog__item owox-catalog-list']")));
        String amount = koli4estvo.getText().replaceAll("[^\\d.]", "");
        int amoun = Integer.parseInt(amount);
        if(amoun > 0) {
            String rubaha = card1.getText();
            System.out.println(rubaha);
            rubaha = rubaha.toLowerCase();
            if (rubaha.contains(tek)) {
                System.out.println("HOROCHO");
            }
        }
        else {
            System.out.println("DICH");
        }
    }
    public void openSort(){driver.get("https://lgcity.ru/outerwear/trench_coats/women/order_price-asc/");}
    @FindBy (xpath = "//div[@id = 'products-list']/a")
    List<WebElement> allCards;

    public void sort(){
        System.out.println(allCards.size());
        //System.out.println(allCards.get(1).getText());//вывод всего текста (работает)
        String itemprop;//аттрибут
        String priceStr;//цена товара
        ArrayList<Integer> prices = new ArrayList<Integer>();
        for (int i=1; i<=allCards.size();i++){
            WebElement card = driver.findElement(By.xpath("//div[@id = 'products-list']/a["+i+"]//div[@class = 'catalog__item-price']"));
            itemprop = card.getAttribute("itemprop");
            if(itemprop.equals("price")){
                priceStr = card.getText().replaceAll("[^\\d.]", "");
                prices.add(Integer.parseInt(priceStr));
            } else{
                WebElement cost = driver.findElement(By.xpath("//div[@id = 'products-list']/a["+i+"]//div[@class = 'catalog__item-price']/div[@class = 'catalog__item-price-new']"));
                priceStr = cost.getText().replaceAll("[^\\d.]", "");
                prices.add(Integer.parseInt(priceStr));
            }
        }
        System.out.println(prices);
        ArrayList<Integer> clone = new ArrayList<Integer>(prices);
        Collections.sort(clone);
        System.out.println(clone);
        Assert.assertEquals(clone, prices);
    }
}
