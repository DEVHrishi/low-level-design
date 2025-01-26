package CouponRecommendation;

import java.util.*;
import java.util.stream.Collectors;


public class CouponRecommendationService {
    private List<RecommendationStrategy> strategies;
    private CouponRepository couponRepository;

    public CouponRecommendationService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
        this.strategies = Arrays.asList(
            new UserHistoryBasedStrategy(couponRepository),
            new BehaviorBasedStrategy(couponRepository)
        );
    }

    public List<Coupon> recommendCoupons(User user) {
        List<Coupon> recommendations = new ArrayList<>();
        
        for (RecommendationStrategy strategy : strategies) {
            recommendations.addAll(strategy.recommendCoupons(user));
        }

        // Remove duplicates
        return recommendations.stream()
            .distinct()
            .collect(Collectors.toList());
    }
    
}
