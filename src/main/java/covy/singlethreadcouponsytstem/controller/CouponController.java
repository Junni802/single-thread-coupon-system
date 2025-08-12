package covy.singlethreadcouponsytstem.controller;

import covy.singlethreadcouponsytstem.IssueCouponRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    /** !!!!!!! API 스펙(HTTP 메서드, URL(PathVariable 포함), Request(Header, Param, Body) 구조, Response(Header, Param, Body))구조는 절대 수정하지 마세요 !!!!!!! */
    /** !!!!!!! 추가적인 패키지나 클래스가 필요하다면 자유롭게 작성해도 됩니다. !!!!!!! */

    @PostMapping("/api/users/{userId}/coupons/issue")
    public void issueCoupon(
        @PathVariable final long userId,
        @RequestBody final IssueCouponRequestDto request
    ) {
        couponService.saveCopuon(userId, request);
    }

    @PostMapping("/api/users/{userId}/coupons/use")
    public UseCouponResponseDto useCoupon(
        @PathVariable final long userId,
        @RequestBody final UseCouponRequestDto request
    ) {
        return couponService.useCoupon(userId, request);
    }

    @GetMapping("/api/users/{userId}/coupons")
    public List<Coupon> getCoupon(@PathVariable final long userId) {
        /** !!!!!!! 해당 API는 절대 수정하지 마세요 !!!!!!! */
        /** !!!!!!! 발급된 쿠폰을 조회를 하기 위한 코드이니 수정하지 마세요 !!!!!!! */
        return couponRepository.findByUserId(userId);
    }
}
