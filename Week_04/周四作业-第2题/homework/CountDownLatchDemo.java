package homework;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangtingting
 * @date 2020-11-09 22:19
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatchTask countDownLatchTask = new CountDownLatchTask(countDownLatch);
        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatchTask.sum();
            }
        }).start();
        int result = countDownLatchTask.getValue();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        System.out.println("退出main线程");
    }

    public static class CountDownLatchTask {
        CountDownLatch countDownLatch;
        Integer value;

        CountDownLatchTask(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        private void sum() {
            value = fibo(36);
            countDownLatch.countDown();
        }

        private int getValue() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return value;
        }

        private static int fibo(int a) {
            if (a < 2)
                return 1;
            return fibo(a - 1) + fibo(a - 2);
        }
    }

}
