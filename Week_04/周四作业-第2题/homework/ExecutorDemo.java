package homework;

import java.util.concurrent.*;

/**
 * @author wangtingting
 * @date 2020-11-09 21:37
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class ExecutorDemo {


    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        int result = 0;
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            result = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return sum();
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        System.out.println("退出main线程");
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
