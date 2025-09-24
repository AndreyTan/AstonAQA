import lesson10.mtspages.PayArrearsPage;
import lesson10.mtspages.PayInstalmentPage;
import lesson10.mtspages.PayInternetPage;
import lesson10.mtspages.PayPhonePage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Проверяем плейсхолдеры оплат услуг")
public class ServicesTest {

    @BeforeAll
    public static void setUpSuite() {
        InitTests.initSetUpTests();
    }

    @Test
    @DisplayName("плейсхолдеры услуг связи")
    public void testPlaceholdersPayPhoneService() {
        PayPhonePage page = new PayPhonePage(InitTests.getDriver());
        page.openPage();
        assertTrue(page.checkPlaceholders("Номер телефона", "Сумма", "E-mail для отправки чека"));
    }

    @Test
    @DisplayName("плейсхолдеры домашнего интернета")
    public void testPlaceholdersPayInternetService() {
        PayInternetPage page = new PayInternetPage(InitTests.getDriver());
        page.openPage();
        assertTrue(page.checkPlaceholders("Номер абонента", "Сумма", "E-mail для отправки чека"));
    }

    @Test
    @DisplayName("плейсхолдеры рассрочки")
    public void testPlaceholdersPayInstalmentService() {
        PayInstalmentPage page = new PayInstalmentPage(InitTests.getDriver());
        page.openPage();
        assertTrue(page.checkPlaceholders("Номер счета на 44", "Сумма", "E-mail для отправки чека"));
    }

    @Test
    @DisplayName("плейсхолдеры задолженности")
    public void testPlaceholdersPayArrearsService() {
        PayArrearsPage page = new PayArrearsPage(InitTests.getDriver());
        page.openPage();
        assertTrue(page.checkPlaceholders("Номер счета на 2073", "Сумма", "E-mail для отправки чека"));
    }


    @AfterAll
    public static void finishTest() {
        InitTests.getDriver().quit();
    }

}
