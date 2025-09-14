import lesson7.MegaMath;
import lesson7.MegaMathArithmeticActions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import  static  org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MegaMathTest {
    private MegaMath megaMath;

    @BeforeEach
    public void beginInit(){
        megaMath = new MegaMath();
    }

    @Test
    @DisplayName("сравниваем числа")
    public void compareWholesTest(){
        assertAll(
                ()-> assertTrue(megaMath.compareWholes(2, 1), "первое число должно быть больше второго"),
                ()-> assertFalse(megaMath.compareWholes(2, 3), "третье число должно быть больше первого")
        );
    }

    @Test
    @DisplayName("вычисляем факториал")
    public void computeFactorialTest(){
        assertAll(
                ()-> assertThrows(ArithmeticException.class,()->megaMath.computeFactorial(-1)),
                ()-> assertEquals(1,megaMath.computeFactorial(0),"метод должен вернуть 1 при параметре 0"),
                ()-> assertEquals(120,megaMath.computeFactorial(5),"метод должен был вернуть 120 при параметре 5")
        );
    }

    @Test
    @DisplayName("совершаем всякие действия с числами")
    public void computeTwoNumbersTest(){
        assertAll(
                ()-> assertThrows(ArithmeticException.class,()->megaMath.computeTwoNumbers(1,0,MegaMathArithmeticActions.divide),"метод должен вернуть ArithmeticException при делении на ноль"),
                ()-> assertThrows(ArithmeticException.class,()->megaMath.computeTwoNumbers(1,1,null),"метод должен вернуть ArithmeticException если третий аргумент null"),
                ()->assertEquals(21,megaMath.computeTwoNumbers(10,11,MegaMathArithmeticActions.add),"10+11 должно было получиться 21"),
                ()->assertEquals(-2,megaMath.computeTwoNumbers(5,7,MegaMathArithmeticActions.subtract),"5-7 должно было получиться -2"),
                ()->assertEquals(132,megaMath.computeTwoNumbers(11,12,MegaMathArithmeticActions.multiply),"11*12 должно было получиться 132"),
                ()->assertEquals(30,megaMath.computeTwoNumbers(90,3,MegaMathArithmeticActions.divide),"90/3 должно было получиться 30")

        );
    }

    @Test
    @DisplayName("вычисляем площадь треугольника")
    public void computeTriangleAreaTest(){
        assertAll(
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(0,0,0)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(1,0,0)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(0,0,1)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(0,1,0)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(0,3,5)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(3,0,5)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(3,5,0)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(-2,-2,-2)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(2,-2,-2)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(-2,2,-2)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(-2,-2,2)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(2,2,-2)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(2,-2,2)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(-2,2,2)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(1,2,3)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(3,2,1)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(1,3,2)),
                ()->assertThrows(ArithmeticException.class,()->megaMath.computeTriangleArea(2,3,1)),
                ()->assertEquals(6,megaMath.computeTriangleArea(3,4,5)),
                ()->assertEquals(6,megaMath.computeTriangleArea(3,5,4)),
                ()->assertEquals(6,megaMath.computeTriangleArea(5,4,3)),
                ()->assertEquals(6,megaMath.computeTriangleArea(5,3,4)),
                ()->assertEquals(6,megaMath.computeTriangleArea(4,5,3)),
                ()->assertEquals(6,megaMath.computeTriangleArea(4,3,5))
        );
    }

}
