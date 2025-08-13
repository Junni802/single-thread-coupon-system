package covy.singlethreadcouponsytstem.service;

import covy.singlethreadcouponsytstem.IssueCouponRequestDto;
import covy.singlethreadcouponsytstem.repository.db.Coupon;
import covy.singlethreadcouponsytstem.repository.db.CouponRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class CouponService {

  private final Object couponInsertLock = new Object();

  private final CouponRepository couponRepository;

  public CouponService(CouponRepository couponRepository) {
    this.couponRepository = couponRepository;
  }

  public synchronized void saveCoupon(long userId, IssueCouponRequestDto request) {
    List<Coupon> couponList = couponRepository.findByUserId(userId);

    boolean match = couponList.stream().anyMatch(m -> m.getType() == request.getType());

    // 쿠폰이 이미 존재하는가?
    if (match) {
      throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "이미 발급된 쿠폰입니다.");
    }

    Coupon coupon = new Coupon(userId, request.getType());
    couponRepository.insert(coupon);
  }

}
