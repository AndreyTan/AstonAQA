package lesson4.geometry;

public class Triangle extends Shape implements IFigure {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3, String colorArea, String colorBorder) {
        super(colorArea, colorBorder);

        try {
            if ((side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) && side1 > 0 && side2 > 0 && side3 > 0) {
                this.side1 = side1;
                this.side2 = side2;
                this.side3 = side3;
            } else {
                throw new Exception("Треугольника не существует");
            }
        } catch (Exception ex) {
            System.out.println("Не удалось построить заданный треугольник. Построен стандартный");
            this.side1 = 1;
            this.side2 = 1;
            this.side3 = 1;
        }

    }

    private double calculateAreaByBaseLength(double baseLength, double height) {
        return (baseLength * height) / 2;
    }

    private double calculateAreaByAngle(double side1, double side2, double angle) {
        return 0.5 * side1 * side2 * Math.sin(angle * Math.PI / 180);
    }

    private double calculateAreaByThreeSide(double side1, double side2, double side3) {
        double halfPer = (side1 + side2 + side3) / 2;

        return Math.sqrt(halfPer * (halfPer - side1) * (halfPer - side2) * (halfPer - side3));
    }


    @Override
    public double calcPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public double calcArea() {
        return calculateAreaByThreeSide(this.side1, this.side2, this.side3);
    }

    @Override
    public String getColorBorder() {
        return colorBorder;
    }

    @Override
    public String getColorArea() {
        return colorArea;
    }

}
