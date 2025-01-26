package CouponRecommendation;

import java.util.*;
import java.util.stream.Collectors;

public class BehaviorBasedStrategy implements RecommendationStrategy {
    private CouponRepository couponRepository;

    public BehaviorBasedStrategy(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public List<Coupon> recommendCoupons(User user) {
        // More complex recommendation logic can be implemented here
        return couponRepository.getCoupons().stream()
            .filter(Coupon::isValid)
            .limit(3)
            .collect(Collectors.toList());
    }
}
