package homework;

import java.util.concurrent.Semaphore;

/**
 * @author wangtingting
 * @date 2020-11-10 22:27
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        SemaphoreTask task = new SemaphoreTask(semaphore);
        task.start();
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
        System.out.println("退出main线程");

    }

    public static class SemaphoreTask extends Thread{
        Semaphore semaphore;
        SemaphoreTask(Semaphore semaphore){
            this.semaphore = semaphore;
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run(){
            long start=System.currentTimeMillis();
            int result = sum();
            System.out.println("异步计算结果为："+result);
            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
            semaphore.release();
        }


    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
