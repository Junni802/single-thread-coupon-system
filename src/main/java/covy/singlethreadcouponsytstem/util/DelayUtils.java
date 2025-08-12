package covy.singlethreadcouponsytstem.util;

/** !!!!!!! 클래스 전체를 절대 수정하지 마세요 !!!!!!! */
public class DelayUtils {
    private DelayUtils() {}

    public static void randomDelay() {
        final long delay = 50 + (long) (Math.random() * 51); // 50ms ~ 100ms 랜덤 지연
        try {
            Thread.sleep(delay);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
