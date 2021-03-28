import Pages.PageFavoriteLgCity;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class FavoriteLgCity extends WebDriverSettings {
    @Test
    public void addFavoriteTest() throws InterruptedException {
        PageFavoriteLgCity favoriteLgCityPage = new PageFavoriteLgCity(driver, wait);

        favoriteLgCityPage.open();
        favoriteLgCityPage.clickShoes();

    }
}
