import lesson3.Park;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("создаём развлекательную индустрию")
public class ParkTests {

    @Test
    @DisplayName("создаём нормальный парк")
    public void testBuildPark(){
        Park cubePark = new Park("cube park");
        cubePark.buildNewAttraction("Wooahhh","For the best orcs",120, LocalTime.of(10,0),LocalTime.of(19,0));
        cubePark.buildNewAttraction("Shoots","Shoot and win",300, LocalTime.of(11,0),LocalTime.of(17,0));

        HashMap<String, Object> infoWooAttr = cubePark.getAttractionInfo("Wooahhh");

        assertAll(
                ()->assertEquals("cube park",cubePark.getTitle()),
                ()->assertEquals("Wooahhh",infoWooAttr.get("title")),
                ()->assertEquals("For the best orcs",infoWooAttr.get("description")),
                ()->assertEquals(120,infoWooAttr.get("cost")),
                ()->assertEquals(LocalTime.of(10,0),infoWooAttr.get("startWork")),
                ()->assertEquals(LocalTime.of(19,0),infoWooAttr.get("endWork"))
        );
    }

    @Test
    @DisplayName("создаём ненормальный парк")
    public void testBuildIncorrectPark(){
        Park incorrectPark = new Park(null);

        assertAll(
                ()-> assertEquals("default title park",incorrectPark.getTitle()),
                ()->assertThrows(IllegalArgumentException.class,()->incorrectPark.buildNewAttraction(null,null,-300, null,null))
        );

        incorrectPark.renamePark("new park title");

        assertEquals("new park title",incorrectPark.getTitle());
    }

}
