package ooh.chaos.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/17
 */
public class ProfileUtil {

    private static AtomicInteger counter = new AtomicInteger(0);

    /**
     *  长生消息id
     *     
     */
    public static long getAtomicCounter() {
        if (counter.get() > 999999) {
            counter.set(1);
        }
        long time = System.currentTimeMillis();
        long returnValue = time * 100 + counter.incrementAndGet();
        return returnValue;
    }

    private static long incrementAndGet() {
        return counter.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0;i < 1000; i++) {
            System.out.println(ProfileUtil.getAtomicCounter());
        }

    }
}
