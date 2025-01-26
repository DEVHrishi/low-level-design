package CouponRecommendation;

import java.util.List;
import java.util.stream.Collectors;

class CouponValidationService {
    public boolean validateCoupon(Coupon coupon, List<Product> cart) {
        if (!coupon.isValid()) return false;

        List<String> cartCategories = cart.stream()
            .map(Product::getCategory)
            .distinct()
            .collect(Collectors.toList());

        return coupon.isApplicable(cartCategories);
    }

    public double calculateDiscount(Coupon coupon, List<Product> cart) {
        switch (coupon.getType()) {
            case PERCENTAGE_DISCOUNT:
                return calculatePercentageDiscount(coupon, cart);
            case FIXED_AMOUNT_DISCOUNT:
                return coupon.getDiscountValue();
            case BUY_ONE_GET_ONE:
                return calculateBOGODiscount(cart);
            default:
                return 0.0;
        }
    }

    private double calculatePercentageDiscount(Coupon coupon, List<Product> cart) {
        double totalCartValue = cart.stream()
            .mapToDouble(Product::getPrice)
            .sum();
        return totalCartValue * (coupon.getDiscountValue() / 100);
    }

    private double calculateBOGODiscount(List<Product> cart) {
        // Simple BOGO implementation
        return cart.stream()
            .mapToDouble(Product::getPrice)
            .min()
            .orElse(0.0);
    }
}