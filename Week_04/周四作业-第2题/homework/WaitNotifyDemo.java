package homework;

/**
 * @author wangtingting
 * @date 2020-11-10 22:37
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        WaitNotifyTask task = new WaitNotifyTask();
        new Thread(new Runnable() {
            @Override
            public void run() {
                task.sumData();

            }
        }).start();
        int result  = task.getResult();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");



    }

    public static class WaitNotifyTask {
        int result;

        public synchronized void sumData(){
            result = sum();
            notifyAll();
        }

        private synchronized int getResult(){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
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
