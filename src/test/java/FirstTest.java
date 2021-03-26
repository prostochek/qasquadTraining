import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*^^^подключаемые библиотеки^^^ программа сама подсказывает, когда надо поключать*/

public class FirstTest {//объявление класса(имя класса должно совпадать с именем файла)
    public WebDriver driver;//объявление драйвера публично, чтобы пользоваться во всем классе
    public String baseUrl;//публичная переменная имени сайта

    @Before
    public void before() {//метод, в котором происходит что-то до старта тестов (аннотация @Before)
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//путь к хромдрайверу(лежит в корне, поэтому просто название)
        driver = new ChromeDriver();//инициализируем драйвер
        baseUrl = "https://yandex.ru/search/?lr=65&text=%D0%BD%D0%BE%D0%B2%D1%8B%D0%B5%20%D1%84%D0%B8%D0%BB%D1%8C%D0%BC%D1%8B&src=suggest_B";//инициализация переменной имени сайта
        driver.manage().window().maximize();//делаем браузер на весь экран
    }

    @Test
    public void first() {//метод, в котором идет сам тест (аннотация @Test)
        driver.get(baseUrl);//команда get откроет сайт, который хранит переменная baseUrl
    }

    @After
    public void quit() {//метод, в котором происходит что-то после отработки тестов (аннотация @After)
        driver.quit();//выключаем драйвер и закрываем все связанные с ним окна
    }
}
