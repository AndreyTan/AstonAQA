package lesson4.geometry;

public class Triangle extends Shape implements ITriangle{
    private double _side1;
    private double _side2;
    private double _side3;

    public Triangle(double side1, double side2, double side3, String colorArea, String colorBorder){
        super(colorArea, colorBorder);

        try {
            if((side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) && side1 > 0 && side2 > 0 && side3 > 0){
                this._side1 = side1;
                this._side2 = side2;
                this._side3 = side3;
            } else {
                throw new Exception("Треугольника не существует");
            }
        } catch (Exception ex){
            System.out.println("Не удалось построить заданный треугольник. Построен стандартный");
            _side1 = 1;
            _side2 = 1;
            _side3 = 1;
        }

    }

    @Override
    public double getPerimeter() {
        return calculatePerimeter(_side1, _side2, _side3);
    }

    @Override
    public double getArea() {
        return calculateAreaByThreeSide(_side1, _side2, _side3);
    }

    @Override
    public void showInfo() {
        System.out.printf("Треугольник [%.2f ; %.2f ; %.2f]. периметр: %.2f ;площадь: %.2f; цвет заливки: %s; цвет границы: %s\n",_side1,_side2,_side3,getPerimeter(),getArea(),_colorArea,_colorBorder);
    }

}
