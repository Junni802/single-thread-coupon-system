package covy.singlethreadcouponsytstem;

import covy.singlethreadcouponsytstem.repository.CouponType;

public class IssueCouponRequestDto {
    private final CouponType type;

    public IssueCouponRequestDto(final CouponType type) {
        this.type = type;
    }

    public CouponType getType() {
        return type;
    }
}
