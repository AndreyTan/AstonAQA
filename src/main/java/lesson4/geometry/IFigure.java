package lesson4.geometry;

public interface IFigure {

    double calcPerimeter();

    double calcArea();

    String getColorBorder();

    String getColorArea();

    default void printInfo() {
        System.out.printf("Периметр: %.2f\tПлощадь: %.2f\tЦвет границы: %s\tЦвет фона: %s\n", calcPerimeter(), calcArea(), getColorBorder(), getColorArea());
    }

}
