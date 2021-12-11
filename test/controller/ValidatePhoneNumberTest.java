package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatePhoneNumberTest {
	
	private PlaceOrderController placeOrderController;
	
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	
	@ParameterizedTest
    @CsvSource({
    	"0123456789, true",
    	"123, false",
    	"1231321213, true"
    	})
	
    void test(String phone, boolean expect){
        boolean isValid = placeOrderController.validatePhoneNumber(phone);

        assertEquals(expect, isValid);
    }

	//@Test
	//void test() {
	//	boolean  isValided = placeOrderController.validatePhoneNumber("123456789");
	//	assertEquals(true, isValided);
	//}

}
