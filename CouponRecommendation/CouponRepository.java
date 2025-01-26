package CouponRecommendation;

import java.time.LocalDateTime;
import java.util.*;

public class CouponRepository {
    private List<Coupon> coupons;

    public CouponRepository() {
        this.coupons = new ArrayList<>();
        initializeSampleCoupons();
    }

    private void initializeSampleCoupons() {
        Coupon electronics = new Coupon.CouponBuilder()
            .id("ELEC20")
            .code("ELECTRONICS20")
            .type(CouponType.PERCENTAGE_DISCOUNT)
            .discountValue(20)
            .validPeriod(LocalDateTime.now(), LocalDateTime.now().plusMonths(1))
            .applicableCategories(Arrays.asList("Electronics"))
            .build();

        Coupon fashion = new Coupon.CouponBuilder()
            .id("FASH15")
            .code("FASHION15")
            .type(CouponType.PERCENTAGE_DISCOUNT)
            .discountValue(15)
            .validPeriod(LocalDateTime.now(), LocalDateTime.now().plusMonths(1))
            .applicableCategories(Arrays.asList("Fashion"))
            .build();

        coupons.add(electronics);
        coupons.add(fashion);
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }
}
