package lesson4.geometry;


public class Circle extends Shape implements IFigure {
    private double radius;

    public Circle(double radius, String colorArea, String colorPer) {
        super(colorArea, colorPer);
        this.radius = (radius > 0) ? radius : 1;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * this.radius * this.radius;
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
