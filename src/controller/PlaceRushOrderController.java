package controller;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.order.Order;
import views.screen.popup.PopupScreen;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Class xu ly logic dat hang giao hang nhanh
 * 
 * @author Somsith PHONPHAKDY - 20180281
 * @since 12/11/2021
 * @version 1.0
 */
public class PlaceRushOrderController extends PlaceOrderController {
    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceRushOrderController.class.getName());
    // Somsith PHONPHAKDY 20180281

    /**
     * 
     * @param info thong tin don giao hang nhanh
     * @throws InterruptedException
     * @throws IOException
     */
    @Override
    public void validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException {
        super.validateDeliveryInfo(info);
        if (!validateProvince(info.get("province"))) {
            throw new InterruptedException(
                    "Province doesn't support rush delivery. Please get back to Cart Screen to unselect rush order");
        }
        // kiem tra tinh hop le cua ngay giao hang
        if (!validateDeliveryDate(info.get("date"))) {
            throw new InterruptedException("Delivery date must be after today");
        }
    }
    // Somsith PHONPHAKDY 20180281

    /**
     * Method kiem tra tinh hop le cua thong tin tinh/thanh pho
     * 
     * @param province ten tinh/thanh pho
     * @return tinh hop le cua thong tin (dang boolean)
     */
    public boolean validateProvince(String province) {
       
        if (province == null || province.isEmpty()) {
            return false;
        }
        
        if (!province.equals("Hà Nội")) {
            return false;
        }
        return true;
    }

    // Somsith PHONPHAKDY 20180281
    /**
     * Method kiem tra tinh hop le cua thong tin ngay giao hang
     * 
     * @param date ngay giao hang
     * @return tinh hop le cua ngay giao hang (dang boolean)
     */
    public boolean validateDeliveryDate(String date) {

        if (date == null) {
            return false;
        }

        if (LocalDate.now().isAfter(LocalDate.parse(date)) || LocalDate.now().isEqual(LocalDate.parse(date))) {
            return false;
        }
        return true;
    }

    // Somsith PHONPHAKDY 20180281
    /**
     * Method tinh phi van chuyen cho don giao hang nhanh
     * 
     * @param order don hang
     * @return phi van chuyen (dang int)
     */
    @Override
    public int calculateShippingFee(Order order) {
        int fees = super.calculateShippingFee(order);
        int rushOrderFee = 10000 * order.getlstOrderMedia().size();
        int totalFees = fees + rushOrderFee;
        LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + totalFees);
        return totalFees;
    } // Somsith PHONPHAKDY 20180281
}
