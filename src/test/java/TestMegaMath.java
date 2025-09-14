import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestMegaMath {
    private MegaMath megaMath;

    @BeforeMethod
    public void beginInit(){
        megaMath = new MegaMath();
    }

    @Test
    public void compareWholesTest(){
        assertTrue(megaMath.compareWholes(100, 20), "первое число должно быть больше второго");
        assertFalse(megaMath.compareWholes(2, 3), "третье число должно быть больше первого");
    }

    @Test
    public void computeFactorialTest() {
        assertThrows(ArithmeticException.class, () -> megaMath.computeFactorial(-1));
        assertEquals(megaMath.computeFactorial(0), 1, "метод должен вернуть 1 при параметре 0");
        assertEquals(megaMath.computeFactorial(5), 120, "метод должен был вернуть 120 при параметре 5");
    }

    @Test
    public void computeTwoNumbersTest() {
        assertThrows(ArithmeticException.class, () -> megaMath.computeTwoNumbers(1, 0, MegaMathArithmeticActions.divide));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTwoNumbers(1, 1, null));
        assertEquals(megaMath.computeTwoNumbers(11, 12, MegaMathArithmeticActions.add), 23, "11+12 должно было получиться 23");
        assertEquals(megaMath.computeTwoNumbers(5, 7, MegaMathArithmeticActions.subtract), -2, "5-7 должно было получиться -2");
        assertEquals(megaMath.computeTwoNumbers(11, 12, MegaMathArithmeticActions.multiply), 132, "11*12 должно было получиться 132");
        assertEquals(megaMath.computeTwoNumbers(90, 3, MegaMathArithmeticActions.divide), 30, "90/3 должно было получиться 30");
    }

    @Test
    public void computeTriangleAreaTest() {
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(0, 0, 0));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(1, 0, 0));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(0, 0, 1));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(0, 1, 0));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(0, 3, 5));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(3, 0, 5));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(3, 5, 0));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(-2, -2, -2));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(2, -2, -2));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(-2, 2, -2));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(-2, -2, 2));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(2, 2, -2));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(2, -2, 2));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(-2, 2, 2));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(1, 2, 3));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(3, 2, 1));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(1, 3, 2));
        assertThrows(ArithmeticException.class, () -> megaMath.computeTriangleArea(2, 3, 1));
        assertEquals(megaMath.computeTriangleArea(3, 4, 5), 6);
        assertEquals(megaMath.computeTriangleArea(3, 5, 4), 6);
        assertEquals(megaMath.computeTriangleArea(5, 4, 3), 6);
        assertEquals(megaMath.computeTriangleArea(5, 3, 4), 6);
        assertEquals(megaMath.computeTriangleArea(4, 5, 3), 6);
        assertEquals(megaMath.computeTriangleArea(4, 3, 5), 6);
    }

}
