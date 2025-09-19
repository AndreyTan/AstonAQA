package lesson4.geometry;

public interface IRectangle {

    default double calculatePerimeter(double width,double length) {
        return 2 * (width + length);
    }


    default double calculateArea(double width,double length) {
        return width * length;
    }
}
