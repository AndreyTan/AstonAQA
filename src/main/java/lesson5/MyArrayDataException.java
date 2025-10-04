package lesson5;

public class MyArrayDataException extends RuntimeException {
    private int row, col;
    private String data;


    public MyArrayDataException(String message, int row, int col, String data) {
        super(message);
        this.row = row;
        this.col = col;
        this.data = data;
    }

    public String getInfoException() {
        return getMessage() + ": " + this.data + " .в строке " + this.row + " колонке " + this.col;
    }

}
