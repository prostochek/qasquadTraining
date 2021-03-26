import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
public class TestClass extends WebDriverSettings {
    @Test
    public void firstTest() {
        driver.get("https://lgcity.ru/outerwear/bombers/women/");
        // List<Integer> arrayList = new ArrayList<Integer>();
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='catalog__item-labels']"));
        List<WebElement> price = driver.findElements(By.xpath("//div[contains(@class,\"catalog__item-price\")]"));
        List<WebElement> listItem = driver.findElements(By.xpath("//div[@class='catalog__item-label catalog__item-label--new']/../../following-sibling::div[@class='catalog__item-price']"));
        if (list.size() != price.size()) {
            List<WebElement> listItemNew = driver.findElements(By.xpath("//div[@class='catalog__item-price-new']"));
            listItem.addAll(listItemNew);
        }
        System.out.println(listItem.size());
        for (WebElement pr : listItem) {
            System.out.println(pr.getText());
        }
//        for (int i = 0; i < list.size(); i++) {
//            String discount = list.get(i).getText();
//
//            if (discount.equals("NEW")) {
//                element = driver.findElement(By.xpath("(//div[@class='catalog__item-price'])[" + i + "]")).getText();
//
//                System.out.println(price);
//                element = element.replaceAll("\\s", "").replaceAll("₽", "");
//                newPrice = Integer.parseInt(element);
//                arrayList.add(newPrice);
//            } else {
//                element = driver.findElement(By.xpath("(//div[@class='catalog__item-price-new'])[" + i + "]")).getText();
//            }
//
//        }
    }
}