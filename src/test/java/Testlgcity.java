import Pages.PageLgCity;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class Testlgcity extends WebDriverSettings {
    @Test
    public void firstTest() throws InterruptedException {

        PageLgCity lgCityPage = new PageLgCity(driver, wait);

        lgCityPage.open();
        lgCityPage.clickMens();
        lgCityPage.clickObuff();



/*****************************************/
        //driver.get("https://lgcity.ru");
        //WebElement forMens = driver.findElement(By.id("menu-326"));
        //forMens.click();
        /*WebElement shoes = driver.findElement(By.id("menu-333"));
        shoes.click();
        WebElement countProd = driver.findElement(By.className("catalog__subtitle"));
        String countP = countProd.getText();
        System.out.println(countP);


        WebElement filter = driver.findElement(By.className("filter__title"));
        filter.click();
        WebElement sale = driver.findElement(By.xpath("//a[contains(text(), 'Распродажа')]"));
        sale.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Да')]")));//переделать

        WebElement yes = driver.findElement(By.xpath("//a[contains(text(), 'Распродажа')]/ancestor::div[@class = 'filter__input-box']" +
                "/following-sibling::div[@class = 'filter__list']//button[contains(text(), 'Выбрать все')]"));
        yes.click();
        WebElement countYes = driver.findElement(By.xpath("//a[contains(text(), 'Распродажа')]/ancestor::div[@class = 'filter__input-box']" +
                "/following-sibling::div[@class = 'filter__list']//button[@class = 'button button--fill filter__button filter__button--apply']"));
        countYes.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Мужская обувь, со скидками')]")));

        WebElement countProd2 = driver.findElement(By.className("catalog__subtitle"));
        String countP2 = countProd2.getText();
        System.out.println(countP2);
        if (countP.equals(countP2)) {//проверка, если значение атрибута не содержит данных из скобок
            Assert.fail("Фильтр не работает (на самом деле работает)");//заваливаем тест с сообщением
        }

        WebElement outerWear = driver.findElement(By.id("menu-331"));
        outerWear.click();
        WebElement firstCard = driver.findElement(By.xpath("//div[@id = 'products-list']/a[@class = 'catalog__item owox-catalog-list']"));
        firstCard.click();

        WebElement nameCard = driver.findElement(By.xpath("//span[@class = 'card__info-desc']"));
        String nameC = nameCard.getText();
        System.out.println(nameC);

        WebElement favorites = driver.findElement(By.id("btn-add-to-favorite"));
        favorites.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'basket-counter__value']")));

        WebElement allFavorites = driver.findElement(By.id("header-favorite"));
        allFavorites.click();

        WebElement cardName = driver.findElement(By.xpath("//div[@class = 'catalog__item-desc']"));
        String cardN = cardName.getText();
        System.out.println(cardN);
        Assert.assertEquals(nameC, cardN);

        WebElement deleteFavorites = driver.findElement(By.xpath("//div[@class = 'favorite__button']"));
        deleteFavorites.click();

        Thread.sleep(5000);
        WebElement order = driver.findElement(By.xpath("//div[contains(text(), 'Список понравившихся товаров пуст')]"));
        Assert.assertTrue(order.isDisplayed());*/
    }
}
