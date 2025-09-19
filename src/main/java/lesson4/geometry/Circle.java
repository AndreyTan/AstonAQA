package lesson4.geometry;

public class Circle extends Shape implements ICircle {
    private double _radius;

    public Circle(double radius,String colorArea,String colorPer){
        super(colorArea,colorPer);
        this._radius = (radius > 0) ? radius : 1;
    }

    @Override
    public double getPerimeter() {
        return calculatePerimeter(_radius);
    }

    @Override
    public double getArea() {
        return calculateArea(_radius);
    }

    @Override
    public void showInfo() {
        System.out.printf("Круг [%.2f]. периметр: %.2f ;площадь: %.2f; цвет заливки: %s; цвет границы: %s\n",_radius,getPerimeter(),getArea(),_colorArea,_colorBorder);
    }

}
