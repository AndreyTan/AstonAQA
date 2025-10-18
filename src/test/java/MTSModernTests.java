import io.github.bonigarcia.wdm.WebDriverManager;
import lesson10.mtspages.PayFormPage;
import lesson10.mtspages.PayPhonePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тестируем блок пополнения мтс")
public class MTSModernTests {
    private PayFormPage payFormPage;
    private static WebDriver driver;

    @BeforeEach
    public void setUpTest() {
        driver = InitTests.getDriver();
        InitTests.openMTS(driver);
        this.payFormPage = new PayFormPage(driver);
    }

    @AfterEach
    void testDownEach(){
        driver.quit();
    }

    @Test
    @DisplayName("проверяем название блока")
    public void testPayWrapper() {
        String h2PayWrapper = this.payFormPage.getTitle();
        h2PayWrapper = h2PayWrapper.replace('\n', ' ');
        assertTrue(h2PayWrapper.matches("Онлайн пополнение.*без комиссии"));
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

        List<WebElement> elems = this.payFormPage.getLogos();
        for(WebElement elem : elems){
            assertTrue(logos.contains(elem.getAttribute("alt")));
        }
    }

    @Test
    @DisplayName("проверяем работоспособность ссылки")
    public void testLink() {
        baseURI = "https://www.mts.by/";

        String pathLink = this.payFormPage.getLink();

        given()
                .get(pathLink)
                .then()
                .statusCode(200);

    }

    @Test
    @DisplayName("тестируем кнопку продолжить")
    public void testForm() {
        PayPhonePage phonePage = new PayPhonePage(driver);
        phonePage.openPage();
        phonePage.fillForm("297777777","33",false);
    }




}
