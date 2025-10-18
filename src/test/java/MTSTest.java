import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;

@DisplayName("Тестируем блок пополнения мтс")
public class MTSTest {
    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest(){
        driver = new ChromeDriver();
        driver.get("https://mts.by/");
        try {
            driver.findElement(By.xpath("//button[@class=\"btn btn_gray cookie__cancel\"]")).click();
        } catch (Exception ex) {}
    }

    @AfterEach
    void testDownEach(){
        driver.quit();
    }

    @Test
    @DisplayName("проверяем название блока")
    void testPayWrapper() {
        String h2PayWrapper = driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]/h2")).getText();
        h2PayWrapper = h2PayWrapper.replace('\n', ' ');

        assertTrue(h2PayWrapper.matches(".*Онлайн пополнение без комиссии.*"));
    }

    @Test
    @DisplayName("проверяем наличие логотипов")
    public void testLogos() {
        HashSet<String> logos = new HashSet<>(5);
        logos.add("Visa");
        logos.add("Verified By Visa");
        logos.add("MasterCard");
        logos.add("MasterCard Secure Code");
        logos.add("Белкарт");

        List<WebElement> elems = driver.findElements(By.xpath("//div[@class=\"pay__partners\"]//li/img"));
        for(WebElement elem : elems){
            assertTrue(logos.contains(elem.getAttribute("alt")));
        }
    }

    @Test
    @DisplayName("проверяем работоспособность ссылки")
    public void testLink() {

        baseURI = "https://www.mts.by/";

        String pathLink = driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]//a")).getAttribute("href");

        given()
                .get(pathLink)
                .then()
                .statusCode(200);

    }

    @Test
    @DisplayName("тестируем кнопку продолжить")
    public void testForm() {
        WebElement inputPhone = driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//input[@id=\"connection-phone\"]"));
        WebElement inputSum = driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//input[@id=\"connection-sum\"]"));
        WebElement btnContinue = driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//button[@class=\"button button__default \"]"));

        inputPhone.click();
        inputPhone.sendKeys("297777777");
        inputSum.click();
        inputSum.sendKeys("33");
        btnContinue.click();

        //iframe[@class='bepaid-iframe']
    }
}
