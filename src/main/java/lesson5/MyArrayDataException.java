package lesson5;

public class MyArrayDataException extends RuntimeException {
    private int _row, _col;
    private String _data;


    public MyArrayDataException(String message, int row, int col, String data) {
        super(message);
        this._row = row;
        this._col = col;
        this._data = data;
    }

    public String getInfoException() {
        return getMessage() + ": " + _data + " .в строке " + _row + " колонке " + _col;
    }
}
