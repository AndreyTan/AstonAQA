import Lesson11.mtspages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Проверяем плейсхолдеры оплат услуг")
public class ServicesTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUpTest() {
        driver = InitTests.getDriver();
        InitTests.openMTS(driver);
    }

    @AfterEach
    void testDownEach(){
        driver.quit();
    }

    @Test
    @DisplayName("плейсхолдеры услуг связи")
    public void testPlaceholdersPayPhoneService() {
        PayPhonePage page = new PayPhonePage(driver);
        page.openPage();
        assertTrue(page.checkPlaceholders("Номер телефона", "Сумма", "E-mail для отправки чека"));
    }

    @Test
    @DisplayName("плейсхолдеры домашнего интернета")
    public void testPlaceholdersPayInternetService() {
        PayInternetPage page = new PayInternetPage(driver);
        page.openPage();
        assertTrue(page.checkPlaceholders("Номер абонента", "Сумма", "E-mail для отправки чека"));
    }

    @Test
    @DisplayName("плейсхолдеры рассрочки")
    public void testPlaceholdersPayInstalmentService() {
        PayInstalmentPage page = new PayInstalmentPage(driver);
        page.openPage();
        assertTrue(page.checkPlaceholders("Номер счета на 44", "Сумма", "E-mail для отправки чека"));
    }

    @Test
    @DisplayName("плейсхолдеры задолженности")
    public void testPlaceholdersPayArrearsService() {
        PayArrearsPage page = new PayArrearsPage(driver);
        page.openPage();
        assertTrue(page.checkPlaceholders("Номер счета на 2073", "Сумма", "E-mail для отправки чека"));
    }

}
