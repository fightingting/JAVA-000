package homework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wangtingting
 * @date 2020-11-09 21:37
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class FutureDemo{


    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>(){
            @Override
            public Integer call(){
                return sum();
            }
        }) ;
        new Thread(task).start();
        int result = 0;
        try {
            result = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
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
