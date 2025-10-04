package lesson4.geometry;

public class Rectangle extends Shape implements IFigure {
    private double width;
    private double length;

    public Rectangle(double width, double len, String colorArea, String colorPer) {
        super(colorArea, colorPer);

        this.width = (width > 0) ? width : 1;
        this.length = (len > 0) ? len : 1;
    }


    @Override
    public double calcPerimeter() {
        return 2 * (this.width + this.length);
    }

    @Override
    public double calcArea() {
        return this.length * this.width;
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
