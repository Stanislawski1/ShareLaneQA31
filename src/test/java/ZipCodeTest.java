import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZipCodeTest {

    /*
    1.Открываем браузер Chrome
    2.В браузере открыть страницу
    3.Ввести в поле Zip Code 4 цифры, например 1234
    4.Нажать кнопку Continue
    5.Проверить что на экране появилась ошибка
    6.Закрыть браузер
     */

    @Test
    public void test() {


        
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");

        browser.quit();
    }
}
