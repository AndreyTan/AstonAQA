import lesson10.mtspages.PayFormPage;
import lesson10.mtspages.PayPhonePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестируем сервис оплаты телефона")
public class PhoneServiceTests {
    private static PayPhonePage _page;
    private static String _phone;
    private static String _sum;

    @BeforeAll
    public static void setUpSuite(){
        InitTests.initSetUpTests();
        _page = new PayPhonePage(InitTests.getDriver());
        _phone = "297777777";
        _sum = "53";
        _page.openPage();
        _page.enterPhone(_phone);
        _page.enterSum(_sum);
        _page.clickContinue();

        InitTests.getDriver().switchTo().frame(InitTests.getDriver().findElement(By.xpath("//iframe[@class=\"bepaid-iframe\"]")));
    }

    @Test
    @DisplayName("проверяем телефон")
    public void testPhone(){
        assertTrue(_page.checkPhoneNumber(_phone),"телефон должен отображаться правильно");
    }

    @Test
    @DisplayName("проверяем сумму в заголовке и кнопке")
    public void testSum(){
        assertTrue(_page.checkSum(Integer.parseInt(_sum)),"сумма должна отображаться правильно");
    }

    @Test
    @DisplayName("проверяем плейсхолдеры")
    public void testPhd(){
        assertTrue(_page.checkPlaceholders(),"плейсхолдеры неправильные");
    }

    @Test
    @DisplayName("проверяем иконки")
    public void testIcons(){
        assertEquals(4,_page.checkIcons());
    }

    @AfterAll
    public static void finishTest(){
        InitTests.getDriver().switchTo().defaultContent();
        InitTests.getDriver().quit();
    }
}
