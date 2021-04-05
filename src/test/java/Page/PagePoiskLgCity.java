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
import java.util.Random;
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

    /**
     * Поиск товаров
     * */
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
    /**
     * Проверка сортировки по цене
     * */
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
/**
 * Проверка города
 * */
    @FindBy (id = "input-user-locate")
    WebElement input;
    @FindBy (id = "btn-save-user-locate")
    WebElement saveLoc;
    public void city(String gorod) throws InterruptedException {
        WebElement location = driver.findElement(By.xpath("//div[@id = 'header-title-user-location']"));
        location.click();
        input.click();
        input.clear();
        input.sendKeys(gorod);
        saveLoc.click();
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Войти')]")));
        WebElement locat = driver.findElement(By.id("header-title-user-location"));
        Assert.assertEquals(locat.getText(), gorod);
    }
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public void popCity() throws InterruptedException {
        WebElement location = driver.findElement(By.id("header-title-user-location"));
        location.click();
        List<WebElement> popCities = driver.findElements(By.xpath("//div[@class='locate__popular-list']/a"));
        int size = popCities.size();
        int rand = getRandomNumberUsingNextInt(1, size+1);
        System.out.println(rand);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Укажите свой город')]")));
        WebElement popGor = driver.findElement(By.xpath("//div[@class='locate__popular-list']/a["+rand+"]"));
        String gorod = popGor.getText();
        popGor.click();
        System.out.println(input.getAttribute("value"));
        saveLoc.click();
        Thread.sleep(3000);
        WebElement locat = driver.findElement(By.id("header-title-user-location"));
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("header-title-user-location"), locat.getText()));
        Assert.assertEquals(gorod, locat.getText());
    }
    @FindBy (id = "menu-342")
    WebElement shoes;
    public void zakaz() throws InterruptedException {
        shoes.click();
        allCards.get(1).click();
        WebElement addKorz = driver.findElement(By.id("btn-add-to-cart"));
        addKorz.click();
        Thread.sleep(1000);
        WebElement goToKorz = driver.findElement(By.id("btn-add-to-cart"));
        goToKorz.click();
        WebElement order = driver.findElement(By.xpath("//botton[contains(text(), 'К оформлению')]"));
        order.click();
    }
}
