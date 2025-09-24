import lesson3.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@DisplayName("Продукт")
@Tag("Product")
public class ProductTests {

    @DisplayName("создаём нормальный продукт")
    @Test
    public void testNormalProduct() {
        Product normalProduct = new Product("Samsung Galaxy S25 Ultra", LocalDate.of(2025, 1, 2), "Vietnam", 103000, false);


        assertAll(
                () -> assertEquals("Samsung Galaxy S25 Ultra", normalProduct.getTitle()),
                () -> assertEquals(LocalDate.of(2025, 1, 2), normalProduct.getProductionDate()),
                () -> assertEquals("Vietnam", normalProduct.getCountryOrigin()),
                () -> assertEquals(103000, normalProduct.getPrice()),
                () -> assertFalse(normalProduct.getBookingStatus())
        );

    }

    @DisplayName("создаём ненормальный продукт")
    @Test
    public void testInnormalProduct() {
        Product innormalProduct = new Product(null, null, null, -1000, true);

        assertAll(
                () -> assertEquals("default product", innormalProduct.getTitle()),
                () -> assertEquals(LocalDate.of(2025, 9, 19), innormalProduct.getProductionDate()),
                () -> assertEquals("Russia", innormalProduct.getCountryOrigin()),
                () -> assertEquals(1000, innormalProduct.getPrice()),
                () -> assertTrue(innormalProduct.getBookingStatus())
        );
    }

}
