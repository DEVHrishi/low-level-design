package CouponRecommendation;

import java.util.*;
import java.util.stream.Collectors;

public class UserHistoryBasedStrategy implements RecommendationStrategy {
    private CouponRepository couponRepository;

    public UserHistoryBasedStrategy(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public List<Coupon> recommendCoupons(User user) {
        // Recommend based on user's past purchase categories
        List<String> preferredCategories = user.getPreferredCategories();
        return couponRepository.getCoupons().stream()
            .filter(coupon -> coupon.isValid())
            .filter(coupon -> coupon.isApplicable(preferredCategories))
            .collect(Collectors.toList());
    }
}
