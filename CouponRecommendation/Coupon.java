package CouponRecommendation;

import java.time.LocalDateTime;
import java.util.List;

public class Coupon {
    private String id;
    private String code;
    private CouponType type;
    private double discountValue;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private List<String> applicableCategories;

    private Coupon() {}

    public static class CouponBuilder {
        private Coupon coupon;

        public CouponBuilder() {
            coupon = new Coupon();
        }

        public CouponBuilder id(String id) {
            coupon.id = id;
            return this;
        }

        public CouponBuilder code(String code) {
            coupon.code = code;
            return this;
        }

        public CouponBuilder type(CouponType type) {
            coupon.type = type;
            return this;
        }

        public CouponBuilder discountValue(double value) {
            coupon.discountValue = value;
            return this;
        }

        public CouponBuilder validPeriod(LocalDateTime from, LocalDateTime until) {
            coupon.validFrom = from;
            coupon.validUntil = until;
            return this;
        }

        public CouponBuilder applicableCategories(List<String> categories) {
            coupon.applicableCategories = categories;
            return this;
        }

        public Coupon build() {
            if (coupon.id == null || coupon.code == null) {
                throw new IllegalStateException("Coupon must have an ID and code");
            }
            return coupon;
        }
    }

    public boolean isValid() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(validFrom) && now.isBefore(validUntil);
    }

    public boolean isApplicable(List<String> productCategories) {
        return applicableCategories.stream()
            .anyMatch(productCategories::contains);
    }

    public CouponType getType() { return type; }
    public double getDiscountValue() { return discountValue; }
    public String getCode() { return code; }
}
