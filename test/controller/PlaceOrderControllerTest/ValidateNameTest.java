package controller.PlaceOrderControllerTest;

import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateNameTest {

    // Somsith PHONPHAKDY 20180281

    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp() {
        placeOrderController = new PlaceOrderController();
    }

    @ParameterizedTest
    @CsvSource({
            "PHONPHAKDY, true",
            "SOMSITH PHONPHAKDY, true",
            ",false",
            "SOM1 SOM SITH, false",
            "S@MS1TH, false",
            "SOMS1TH,false",
            "S@OM, false",
    })
    void validateName(String name, boolean expected) {
        boolean rs = placeOrderController.validateName(name);
        assertEquals(expected, rs);
    }
}
