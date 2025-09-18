package lesson3;

import java.time.LocalDate;

public class Product {
    private String _title;
    private LocalDate _productionDate;
    private String _countryOrigin;
    private int _price;
    private boolean _isBooking;

    public Product(String title, LocalDate date, String country, int price, boolean isBooking){
        this._title = title;
        this._productionDate = date;
        this._countryOrigin = country;
        this._price = (price < 0)?price * -1:price;
        this._isBooking = isBooking;
    }

    public void printInfo(){
        System.out.println("title: " + _title);
        System.out.println("production date: " +  _productionDate);
        System.out.println("country origin: " + _countryOrigin);
        System.out.println("price: " + _price);
        System.out.println("booking: " + _isBooking);
    }
}
