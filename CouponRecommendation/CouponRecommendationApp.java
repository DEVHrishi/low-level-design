package CouponRecommendation;

import java.util.Arrays;
import java.util.List;


public class CouponRecommendationApp {
    public static void main(String[] args) {
        // Create Coupon Repository
        CouponRepository couponRepository = new CouponRepository();

        // Create Recommendation Service
        CouponRecommendationService recommendationService = 
            new CouponRecommendationService(couponRepository);

        // Create User
        User user = new User("USER001", "user@example.com");

        // Create Some Products
        Product laptop = new Product("PROD001", "Laptop", "Electronics", 1000.0);
        Product phone = new Product("PROD002", "Smartphone", "Electronics", 500.0);
        Product shirt = new Product("PROD003", "T-Shirt", "Fashion", 50.0);

        // Simulate a Purchase
        Purchase purchase = new Purchase(user, Arrays.asList(laptop, phone));
        user.addPurchase(purchase);

        // Get Coupon Recommendations
        List<Coupon> recommendations = recommendationService.recommendCoupons(user);

        // Print Recommendations
        System.out.println("Recommended Coupons:");
        recommendations.forEach(coupon -> 
            System.out.println("Coupon Code: " + coupon.getCode()));

        // Validate and Calculate Discount
        CouponValidationService validationService = new CouponValidationService();
        
        if (!recommendations.isEmpty()) {
            Coupon selectedCoupon = recommendations.get(0);
            
            if (validationService.validateCoupon(selectedCoupon, Arrays.asList(laptop, phone))) {
                double discount = validationService.calculateDiscount(selectedCoupon, Arrays.asList(laptop, phone));
                System.out.println("Applicable Discount: $" + discount);
            }
        }
    }
}