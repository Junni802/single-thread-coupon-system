package covy.singlethreadcouponsytstem.repository.db;


import static covy.singlethreadcouponsytstem.util.DelayUtils.randomDelay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

/** !!!!!!! 클래스 전체를 절대 수정하지 마세요 !!!!!!! */
@Repository
public class CouponRepository {
    private final Map<Long, List<Coupon>> db = new ConcurrentHashMap<>();

    public List<Coupon> findByUserId(final long userId) {
        randomDelay();
        return db.getOrDefault(userId, List.of());
    }

    public Coupon insert(final Coupon coupon) {
        randomDelay();
        db.computeIfAbsent(coupon.getUserId(), k -> new ArrayList<>()).add(coupon);
        return coupon;
    }

    public void delete(final Coupon coupon) {
        randomDelay();
        final List<Coupon> list = db.get(coupon.getUserId());
        if (list == null || list.isEmpty()) {
            return;
        }
        list.remove(coupon);
    }

    public void clearDbForTest() {
        /** !!!!!!! 해당 메서드는 DB에 대한 테스트가 필요할 때 사용하세요 !!!!!!! */
        db.clear();
    }
}
