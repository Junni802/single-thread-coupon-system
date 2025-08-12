package covy.singlethreadcouponsytstem.repository.db;

import covy.singlethreadcouponsytstem.repository.CouponType;
import java.time.LocalDateTime;

/** !!!!!!! 클래스 전체를 절대 수정하지 마세요 !!!!!!! */
public class Coupon {
    private final long userId;
    private final CouponType type;
    private final LocalDateTime issuedAt = LocalDateTime.now();

    public Coupon(final long userId, final CouponType type) {
        this.userId = userId;
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public CouponType getType() {
        return type;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "userId=" + userId +
                ", type=" + type +
                ", issuedAt=" + issuedAt +
                '}';
    }
}
