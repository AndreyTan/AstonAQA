package lesson4.geometry;

public class Rectangle extends Shape implements IRectangle{
    private double _width;
    private double _length;

    public Rectangle(double width, double len, String colorArea, String colorPer){
        super(colorArea, colorPer);

        this._width = (width > 0) ? width : 1;
        this._length = (len > 0) ? len : 1;
    }


    @Override
    public double getPerimeter() {
        return calculatePerimeter(_width, _length);
    }

    @Override
    public double getArea() {
        return calculateArea(_width, _length);
    }

    @Override
    public void showInfo() {
        System.out.printf("Прямоугольник [%.2f ; %.2f]. периметр: %.2f ;площадь: %.2f; цвет заливки: %s; цвет границы: %s\n",_width,_length,getPerimeter(),getArea(),_colorArea,_colorBorder);
    }
}
