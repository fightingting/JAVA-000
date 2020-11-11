package homework;

/**
 * @author wangtingting
 * @date 2020-11-10 22:01
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class JoinDemo {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int result = sum();
                // 确保  拿到result 并输出
                System.out.println("异步计算结果为："+result);
                System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

            }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
