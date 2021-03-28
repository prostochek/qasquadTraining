import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSortirovka extends WebDriverSettings{
    @Test
    public void TestCalculatePrice() throws InterruptedException {
        driver.get("https://lgcity.ru");
        WebElement outerWear = driver.findElement(By.xpath("//a[@id = 'menu-340']/parent::div"));
        Actions actions = new Actions(driver);
        actions.moveToElement(outerWear).perform();//фокусировка на элементе(для выпадающего меню)
        /**Сделать нормальное ожидание**/
        Thread.sleep(3000);
        WebElement tranchCats = driver.findElement(By.id("menu-486"));
        tranchCats.click();
        WebElement poNew = driver.findElement(By.xpath("//button[contains(text(), 'По новинкам ↓')]"));
        poNew.click();
        Thread.sleep(2000);

        /**Выбор карточек**/
        for(int i = 1;i < 5; i++){
            WebElement iCard = driver.findElement(By.xpath("//div[@id='products-list']/a["+i+"]"));
            iCard.click();
            WebElement goToBasket = driver.findElement(By.xpath("//button[@id='btn-add-to-cart']"));
            goToBasket.click();
            WebElement bread = driver.findElement(By.xpath("//div[@class = 'breadcrumbs breadcrumbs--item-card']//span[contains(text(), 'Тренчкоты')]"));
            bread.click();
        }
        /**Выбор карточек закончился**/

        WebElement basket = driver.findElement(By.id("header-basket"));
        basket.click();
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class ='basket__item-price']"));//товары в корзине
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class = 'basket__item-price-num js-basket-product-price basket__item-price-num--disc']"));//товары по скидке в корзине
        if (allPrices.size() != prices.size()) {
            List<WebElement> pricesProst = driver.findElements(By.xpath("//div[@class='basket__item-price-num js-basket-product-price']"));
            prices.addAll(pricesProst);//дозакинули товары без скидки
        }
        System.out.println(prices.size());
        String arrPrice[] = new String[prices.size()];
        Integer intPrice[] = new Integer[prices.size()];
        int cost = 0;
        System.out.println(prices.get(2).getText());
        for (int i = 0;i < prices.size();i++) {
            arrPrice[i] = prices.get(i).getText();
            arrPrice[i] = arrPrice[i].replaceAll("\\s", "").replaceAll("₽", "");
            intPrice[i] = Integer.parseInt(arrPrice[i]);
            //System.out.println(intPrice[i]);
            cost = cost + intPrice[i];
        }
        System.out.println(cost);
        Thread.sleep(3000);
        WebElement costElem = driver.findElement(By.xpath("//span[@id = 'basket-total-price']"));
        //System.out.println(costElem.getText());
        int totalCost=0;
        String textCost = costElem.getText();
        textCost = textCost.replaceAll(" ", "");
        totalCost = Integer.parseInt(textCost);
        System.out.println(totalCost);
        Assert.assertEquals(cost, totalCost);

    }

    @Test
    public void sortirovkaTest() throws InterruptedException {
        driver.get("https://lgcity.ru/outerwear/trench_coats/women/order_price-desc/");
        /*WebElement outerWear = driver.findElement(By.xpath("//a[@id = 'menu-340']/parent::div"));
        Actions actions = new Actions(driver);
        actions.moveToElement(outerWear).perform();//фокусировка на элементе(для выпадающего меню)
        Thread.sleep(3000);

        WebElement tranchCats = driver.findElement(By.id("menu-486"));
        tranchCats.click();
        WebElement poNew = driver.findElement(By.xpath("//button[contains(text(), 'По новинкам ↓')]"));
        poNew.click();
        Thread.sleep(2000);
        WebElement decreasePrice = driver.findElement(By.xpath("//button[contains(text(), 'По убыванию цены ↑')]"));
        decreasePrice.click();*/

        List<WebElement> allCards = driver.findElements(By.xpath("//a[contains(@id, 'bx_1118835136_')]"));
        System.out.println(allCards.size()+" - кол-во товаров");

        /*List<WebElement> cardPrice = driver.findElements(By.xpath("//div[@class = 'catalog__item-price']"));
        String arrPrice[] = new String[allCards.size()];
        for (int i = 0;i < allCards.size();i++){
            //System.out.println(allCards.get(i).findElement(By.xpath("//div[@class = 'catalog__item-price-new']")).getText());
            arrPrice[i] = cardPrice.get(i).getText();
            System.out.println(arrPrice[i]);
        }*/
        /**Альтернатива сбора элементов со странички**/
        WebElement iCard[] = new WebElement[allCards.size()];
        String proba = new String();
        for (int i = 1;i < allCards.size()+1;i++){
            iCard[i-1] = driver.findElement(By.xpath("//div[@id = 'products-list']/a["+i+"]"));
            //System.out.println(iCard[i].getText());
            proba = iCard[i-1]/*.findElement(By.xpath("//div[@class = 'catalog__item-price-new']"))*/.getText();
            System.out.println(proba + "- "+i+" элемент");
        }
        //System.out.println(iCard[2].getText());

    }
}
