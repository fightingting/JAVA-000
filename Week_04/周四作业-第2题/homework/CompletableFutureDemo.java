package homework;

import java.util.concurrent.CompletableFuture;

/**
 * @author wangtingting
 * @date 2020-11-10 23:16
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        int result = CompletableFuture.supplyAsync(()-> sum()).join();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
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
