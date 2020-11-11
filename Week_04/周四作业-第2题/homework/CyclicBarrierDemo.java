package homework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wangtingting
 * @date 2020-11-09 22:46
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        CyclicBarrierTask task = new CyclicBarrierTask();
        CyclicBarrier barrier = new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                Integer result = task.getValue();
                System.out.println("异步计算结果为："+result);
                System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
                System.out.println("退出main线程");
            }
        });
        task.setBarrier(barrier);
        new Thread(new Runnable() {
            @Override
            public void run() {
                task.sum();
            }
        }).start();

    }

    public static class CyclicBarrierTask {
        CyclicBarrier barrier;
        Integer value;

        public void setBarrier(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        private void sum() {
            value = fibo(36);
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private int getValue() {
            return value;
        }

        private static int fibo(int a) {
            if (a < 2)
                return 1;
            return fibo(a - 1) + fibo(a - 2);
        }

    }

}
