package lesson5;


public class Main {
    public static void main(String[] args) {
        String[][] matrix1 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] matrix2 = {
                {"1", "1", "1", "1"},
                {"1", "as", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] matrix3 = {
                {"1", "1", "1"},
                {"1", "1", "1"},
                {"1", "1", "1"},
                {"1", "1", "1"}
        };

        String[][] matrix4 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "6", "154"},
                {"1", "1", "1", "1"}
        };

        checkAndCalculateArray(matrix1);
        checkAndCalculateArray(matrix2);
        checkAndCalculateArray(matrix3);
        checkAndCalculateArray(matrix4);


    }

    public static void checkAndCalculateArray(String[][] matrix) {
        try {
            System.out.printf("Сумма в массиве: %d\n", calculateArray(matrix));
        } catch (MyArraySizeException ex) {
            System.out.printf("Ошибка в обработке массива: %s\n", ex.getMessage());
        } catch (MyArrayDataException ex) {
            System.out.printf("Ошибка в обработке массива: %s\n", ex.getInfoException());
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.printf("Индекс вышел за пределы массива: %s\n", ex.getMessage());
        }
    }

    public static int calculateArray(String[][] matrix) throws MyArraySizeException, MyArrayDataException, ArrayIndexOutOfBoundsException {
        if (matrix.length != 4 || matrix[0].length != 4)
            throw new MyArraySizeException(matrix.length + " на " + matrix[0].length + " - недопустимый размер массива!");
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("Неверные данные", i, j, matrix[i][j]);
                }
            }
        }


        return sum;
    }
}