import Lesson11.mtspages.PayPhonePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тестируем сервис оплаты телефона")
public class PhoneServiceTests {
    private static PayPhonePage page;
    private static String phone;
    private static String sum;
    private static WebDriver driver;

    @BeforeAll
    public static void setUpSuite() {
        phone = "297777777";
        sum = "53";
    }

    @BeforeEach
    public void setUpTest() {
        driver = InitTests.getDriver();
        InitTests.openMTS(driver);
        //this.payFormPage = new PayFormPage(driver);
        page = new PayPhonePage(driver);
        page.openPage();
        page.fillForm(phone,sum,true);
    }

    @AfterEach
    void testDownEach(){
        driver.quit();
    }

    @Test
    @DisplayName("проверяем телефон")
    public void testPhone() {
        assertTrue(page.checkPhoneNumber(phone), "телефон должен отображаться правильно");
    }

    @Test
    @DisplayName("проверяем сумму в заголовке и кнопке")
    public void testSum() {
        assertTrue(page.checkSum(Integer.parseInt(sum)), "сумма должна отображаться правильно");
    }

    @Test
    @DisplayName("проверяем плейсхолдеры")
    public void testPhd() {
        assertTrue(page.checkPlaceholders(), "плейсхолдеры неправильные");
    }

    @Test
    @DisplayName("проверяем иконки")
    public void testIcons() {
        assertTrue(page.checkIcons());
    }


}
