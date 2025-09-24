import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        MegaMath megaMath = new MegaMath();

        BigInteger comp_a = BigInteger.valueOf(100), comp_b = BigInteger.valueOf(525);

        switch (megaMath.compareWholes(comp_a, comp_b)) {
            case 1:
                System.out.printf("%d > %d", comp_a, comp_b);
                break;
            case 0:
                System.out.printf("%d = %d ", comp_a, comp_b);
                break;
            case -1:
                System.out.printf("%d < %d ", comp_a, comp_b);
                break;
        }
        System.out.println("\n-----------------------------");

        int fact = 6;

        System.out.printf("факториал %d = %d", fact, megaMath.computeFactorial(fact));

        System.out.println("\n-----------------------------");

        int sideA = 5, sideB = 5, sideC = 5;
        try {
            System.out.printf("площадь треугольника: %.2f", megaMath.computeTriangleArea(sideA, sideB, sideC));
        } catch (ArithmeticException ex) {
            System.out.println("упс..неправильный треугольник");
        }

    }
}