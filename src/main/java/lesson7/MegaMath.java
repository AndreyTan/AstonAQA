package lesson7;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MegaMath {

    public int compareWholes(BigInteger a, BigInteger b) {
        return a.compareTo(b);
    }

    public BigInteger computeFactorial(int num) throws ArithmeticException {
        if (num == 0) return BigInteger.valueOf(1);
        if (num < 0)
            throw new ArithmeticException("The numbers should only be positive");

        BigInteger sum = BigInteger.valueOf(1);

        for (int i = 1; i <= num; i++) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        return sum;
    }

    public BigDecimal computeTwoNumbers(BigDecimal f, BigDecimal s, MegaMathArithmeticActions action) throws ArithmeticException {
        if (action == null)
            throw new ArithmeticException("некорректное действие");
        switch (action) {
            case add -> {
                return f.add(s);
            }
            case subtract -> {
                return f.subtract(s);
            }
            case multiply -> {
                return f.multiply(s);
            }
            case divide -> {
                if (s.equals(BigInteger.valueOf(0)))
                    throw new ArithmeticException("деление на ноль");
                return f.divide(s);
            }
        }
        return new BigDecimal(0);
    }

    public double computeTriangleArea(double side1, double side2, double side3) throws ArithmeticException {
        if (side1 > 0 && side3 > 0 && side2 > 0 && side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
            double p = (side1 + side2 + side3) / 2;
            return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        } else {
            throw new ArithmeticException("треугольника не существует");
        }
    }


}
