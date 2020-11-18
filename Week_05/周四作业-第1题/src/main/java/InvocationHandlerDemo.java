import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangtingting
 * @date 2020-11-14 18:24
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class InvocationHandlerDemo implements InvocationHandler {

    private IStudent student;

    InvocationHandlerDemo(IStudent student){
        this.student = student;
    }

    private void beforeMethod(){
        System.out.println("-----before-----");
    }

    private void afterMethod(){
        System.out.println("-----after-----");
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeMethod();
        method.invoke(student,args);
        afterMethod();
        return null;
    }

    public static void main(String[] args) {
        IStudent student = (IStudent)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IStudent.class}, new InvocationHandlerDemo(new Student()));
        student.goSchool("Tom");
    }
}
