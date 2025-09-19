package lesson4.geometry;

public interface ICircle {
    default double calculateArea(double radius){
        return Math.PI * radius * radius;
    }

    default double calculatePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }
}
