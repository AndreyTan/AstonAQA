import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import  static  org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

@DisplayName("Тестируем блок пополнения мтс")
public class MTSTest {
    private static WebDriver driver;
    private String xpathPayWrapper = "//div[@class=\"pay__wrapper\"]/h2";

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("проверяем название блока")
    void testPayWrapper() {
        driver.get("http://mts.by/");

        String h2PayWrapper = driver.findElement(By.xpath(xpathPayWrapper)).getText();
        System.out.println(h2PayWrapper);
    }
    //count(//div[@class="pay__partners"]//li/img)
    @Test
    @DisplayName("проверяем наличие логотипов")
    public void testLogos(){
        driver.get("http://mts.by/");
        List<WebElement> elems = driver.findElements(By.xpath("//div[@class=\"pay__partners\"]//li/img"));

        assertEquals(5,elems.size());
    }
    @Test
    @DisplayName("проверяем работоспособность ссылки")
    public void testLink(){
        driver.get("http://mts.by/");
        baseURI = "https://www.mts.by/";

        String pathLink = driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]//a")).getAttribute("href");

        given()
                .get(pathLink)
                .then()
                .statusCode(200);

    }

    @Test
    @DisplayName("тестируем кнопку продолжить")
    public void testForm(){
        driver.get("http://mts.by/");
        WebElement inputPhone = driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//input[@id=\"connection-phone\"]"));
        WebElement inputSum = driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//input[@id=\"connection-sum\"]"));
        WebElement btnContinue = driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//button[@class=\"button button__default \"]"));

        inputPhone.click();
        inputPhone.sendKeys("297777777");
        inputSum.click();
        inputSum.sendKeys("33");
        btnContinue.click();
    }
}
