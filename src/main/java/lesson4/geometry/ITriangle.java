package lesson4.geometry;

public interface ITriangle {
    default double calculatePerimeter(double side1,double side2,double side3) {
        return side1 + side2 + side3;
    }


    default double calculateAreaByBaseLength(double baseLength,double height) {
        return (baseLength * height) / 2;
    }

    default double calculateAreaByAngle(double side1,double side2, double angle) {
        return 0.5 * side1 * side2 * Math.sin(angle * Math.PI / 180);
    }

    default double calculateAreaByThreeSide(double side1,double side2, double side3) {
        double halfPer = (side1 + side2 + side3) / 2;

        return Math.sqrt(halfPer * (halfPer - side1) * (halfPer - side2) * (halfPer - side3));
    }

}
