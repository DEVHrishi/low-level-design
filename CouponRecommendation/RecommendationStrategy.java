package CouponRecommendation;

import java.util.List;

public interface RecommendationStrategy {

    List<Coupon> recommendCoupons(User user);
}
