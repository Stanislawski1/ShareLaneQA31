import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest {

    /*
    1.Открываем браузер Chrome
    2.В браузере открыть страницу
    3.Ввести в поле Zip Code 4 цифры, например 1234
    4.Нажать кнопку Continue
    5.Заполнить форму регистрации
    6.Нажать кнопку register
    7.Проверить, что на странице есть сообщение Account is created
    8.Закрыть браузер
     */

    @Test
    public void checkSignUpValidUserData(){
        WebDriver browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        browser.findElement(By.name("first_name")).sendKeys("test");
        browser.findElement(By.name("last_name")).sendKeys("test");
        browser.findElement(By.name("email")).sendKeys("test@test.test");
        browser.findElement(By.name("password1")).sendKeys("12345678");
        browser.findElement(By.name("password2")).sendKeys("12345678");
        browser.findElement(By.cssSelector("[value=Register]")).click();
        String message = browser.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(message, "Account is created!");
        //ID --> Name --> CSS --> XPATH

        browser.quit();

    }
}
