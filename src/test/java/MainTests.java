import lesson2.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("чуть-чуть тестируем Main")
public class MainTests {

    @DisplayName("тестируем сумму двух чисел в пределах от 10 до 20")
    @Test
    public void testSumSign(){
        assertAll(
                ()->assertFalse(Main.checkSumRange(5,5)),
                ()->assertTrue(Main.checkSumRange(5,6)),
                ()->assertTrue(Main.checkSumRange(10,10)),
                ()->assertFalse(Main.checkSumRange(10,11))
        );
    }

    @DisplayName("проверяем число на негатив")
    @Test
    public void testNumSign(){
        assertAll(
                ()->assertTrue(Main.checkNumNegSing(-1)),
                ()->assertFalse(Main.checkNumNegSing(0)),
                ()->assertFalse(Main.checkNumNegSing(13431))
        );
    }

    @DisplayName("выводим строку указанное количество раз")
    @Test
    public void testPrintString(){
        assertAll(
                ()-> assertThrows(IllegalArgumentException.class,()->Main.printString(null,-1))
        );
    }

    @DisplayName("вычисляем високосный год")
    @Test
    public void testLeapYear(){
        assertAll(
                ()-> assertTrue(Main.checkLeapYear(2004)),
                ()-> assertTrue(Main.checkLeapYear(2000)),
                ()-> assertFalse(Main.checkLeapYear(1900)),
                ()-> assertFalse(Main.checkLeapYear(2001)),
                ()-> assertFalse(Main.checkLeapYear(1)),
                ()-> assertThrows(IllegalArgumentException.class,()->Main.checkLeapYear(0)),
                ()-> assertThrows(IllegalArgumentException.class,()->Main.checkLeapYear(-1))
        );
    }

    @DisplayName("генерируем квадратный массив")
    @Test
    public void testGenerateAndPrintQuadArray(){
        assertAll(
                ()-> assertDoesNotThrow(()->Main.generateAndPrintQuadArray(2)),
                ()-> assertThrows(IllegalArgumentException.class,()->Main.generateAndPrintQuadArray(1)),
                ()-> assertThrows(IllegalArgumentException.class,()->Main.generateAndPrintQuadArray(0)),
                ()-> assertThrows(IllegalArgumentException.class,()->Main.generateAndPrintQuadArray(-1))
        );
    }

    @DisplayName("генерируем массив и заполняем чем-то")
    @Test
    public void testCreateArray(){
        assertAll(
                ()-> assertDoesNotThrow(()->Main.createArray(1,1300)),
                ()-> assertThrows(IllegalArgumentException.class,()->Main.createArray(0,1300)),
                ()-> assertThrows(IllegalArgumentException.class,()->Main.createArray(-1,1300))
        );
    }


}
