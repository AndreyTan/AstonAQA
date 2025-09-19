package lesson3;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private String _title;
    private LocalDate _productionDate;
    private String _countryOrigin;
    private int _price;
    private boolean _isBooking;

    public Product(String title, LocalDate date, String country, int price, boolean isBooking){
        this._title = Objects.requireNonNullElse(title,"default product");
        this._productionDate = Objects.requireNonNullElse(date,LocalDate.now());
        this._countryOrigin = Objects.requireNonNullElse(country,"Russia");
        this._price = (price < 0)?-price:price;
        this._isBooking = isBooking;
    }

    public void printInfo(){
        System.out.println("title: " + _title);
        System.out.println("production date: " +  _productionDate);
        System.out.println("country origin: " + _countryOrigin);
        System.out.println("price: " + _price);
        System.out.println("booking: " + _isBooking);
    }

    public String getTitle(){
        return _title;
    }

    public LocalDate getProductionDate(){
        return _productionDate;
    }

    public String getCountryOrigin(){
        return _countryOrigin;
    }

    public int getPrice(){
        return _price;
    }

    public boolean getBookingStatus(){
        return _isBooking;
    }

}
