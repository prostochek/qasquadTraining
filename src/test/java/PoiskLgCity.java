
import Pages.PagePoiskLgCity;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class PoiskLgCity extends WebDriverSettings {
    @Test
    public void searchTest() throws InterruptedException {
        PagePoiskLgCity poiskLgCityPage = new PagePoiskLgCity(driver, wait);

        poiskLgCityPage.open();
        poiskLgCityPage.search("футболка");

    }
    @Test
    public void goVTeset() {
        PagePoiskLgCity krakozyabra = new PagePoiskLgCity(driver, wait);

        krakozyabra.open();
        krakozyabra.search("/.<script>,/,vesa");
    }
    @Test
    public void sortirovka() {
        PagePoiskLgCity sort = new PagePoiskLgCity(driver, wait);
        sort.openSort();
        sort.sort();
    }
}
