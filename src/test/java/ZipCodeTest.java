import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


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
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("1234");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessage = browser.findElement(By.className("error_message")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }

    @Test
    public void testTwo() {

        WebDriver browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        String signUp = browser.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/p/b")).getText();
        Assert.assertEquals(signUp, "Sign Up");
        browser.quit();
    }
}
