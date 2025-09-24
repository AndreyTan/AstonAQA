import lesson10.mtspages.PayFormPage;
import lesson10.mtspages.PayPhonePage;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тестируем блок пополнения мтс")
public class MTSModernTests {
    private PayFormPage _payFormPage;


    @BeforeAll
    public static void setUpSuite() {
        InitTests.initSetUpTests();
    }

    @BeforeEach
    public void setUpTest() {
        this._payFormPage = new PayFormPage(InitTests.getDriver());
    }

    @Test
    @DisplayName("проверяем название блока")
    public void testPayWrapper() {
        String h2PayWrapper = _payFormPage.getTitle();
        h2PayWrapper = h2PayWrapper.replace('\n', ' ');
        assertTrue(h2PayWrapper.matches("Онлайн пополнение.*без комиссии"));
    }

    @Test
    @DisplayName("проверяем наличие логотипов")
    public void testLogos() {
        assertEquals(5, _payFormPage.getLogos().size());
    }

    @Test
    @DisplayName("проверяем работоспособность ссылки")
    public void testLink() {
        baseURI = "https://www.mts.by/";

        String pathLink = _payFormPage.getLink();

        given()
                .get(pathLink)
                .then()
                .statusCode(200);

    }

    @Test
    @DisplayName("тестируем кнопку продолжить")
    public void testForm() {
        PayPhonePage phonePage = new PayPhonePage(InitTests.getDriver());
        phonePage.openPage();
        phonePage.enterPhone("297777777");
        phonePage.enterSum("33");
        phonePage.clickContinue();
    }


    @AfterAll
    public static void finishTest() {
        InitTests.getDriver().quit();
    }

}
