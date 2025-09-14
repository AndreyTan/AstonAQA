package lesson7;

public class MegaMath {

    public boolean compareWholes(int a, int b){
        return a > b;
    }

    public long computeFactorial(int num) throws ArithmeticException{
        if(num == 0) return 1;
        if(num < 0)
            throw new ArithmeticException("The numbers should only be positive");

        long sum = 1;

        for(int i = 1; i <= num;i++){
            sum *= i;
        }
        return sum;
    }

    public double computeTwoNumbers(double f, double s, MegaMathArithmeticActions action) throws ArithmeticException{
        if(action == null)
            throw new ArithmeticException("некорректное действие");
        switch (action){
            case MegaMathArithmeticActions.add -> {
                return f + s;
            }
            case MegaMathArithmeticActions.subtract -> {
                return f - s;
            }
            case MegaMathArithmeticActions.multiply -> {
                return f * s;
            }
            case MegaMathArithmeticActions.divide -> {
                if(s == 0)
                    throw new ArithmeticException("деление на ноль");
                return f / s;
            }
        }
        return 0;
    }

    public double computeTriangleArea(double side1,double side2,double side3) throws ArithmeticException{
        if(side1 > 0 && side3 > 0 && side2 > 0 && side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1){
            double p = (side1 + side2 + side3) / 2;
            return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        } else {
            throw new ArithmeticException("треугольника не существует");
        }
    }


}
