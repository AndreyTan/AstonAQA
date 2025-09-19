package lesson4.geometry;

public abstract class Shape {

    protected String _colorArea;
    protected String _colorBorder;

    public Shape(String colorArea, String colorBorder){
        this._colorArea = colorArea;
        this._colorBorder = colorBorder;
    }

    public abstract double getPerimeter();

    public abstract double getArea();

    public abstract void showInfo();

}
