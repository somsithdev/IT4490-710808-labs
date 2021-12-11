package controller.PlaceRushOrderControllerTest;

import controller.PlaceOrderController;
import controller.PlaceRushOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateProvinceTest {
    // Somsith PHONPHAKDY 20182081
    private PlaceRushOrderController placeRushOrderController;

    @BeforeEach
    void setUp() {
        placeRushOrderController = new PlaceRushOrderController();
    }

    @ParameterizedTest
    @CsvSource({
            "Hà Nội, true",
            "Ha Noi, false",
            "Quảng bình, false",
            ", false"
    })
    void validateProvince(String province, boolean expected) {
        boolean rs = placeRushOrderController.validateProvince(province);
        assertEquals(expected, rs);
    }
}
