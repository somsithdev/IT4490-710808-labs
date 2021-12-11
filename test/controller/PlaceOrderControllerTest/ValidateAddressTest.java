package controller.PlaceOrderControllerTest;

import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateAddressTest {

    // Somsith PHONPHAKDY 20180281

    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp() {
        placeOrderController = new PlaceOrderController();
    }

    @ParameterizedTest
    @CsvSource({
            "22 TA Quang Buu, true",
            "So t@ Quang buu , false",
            ", false"
    })
    void validateAddress(String address, boolean expected) {
        // when
        boolean rs = placeOrderController.validateAddress(address);
        // then
        assertEquals(expected, rs);
    }
}
