import beanAnnotationDemo.Student2;
import beanAnnotationDemo.Student2Config;
import componentDemo.Student1;
import componentDemo.Student1Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xmlDemo.Student;

/**
 * @author wangtingting
 * @date 2020-11-18 14:41
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
@ComponentScan
public class BeanDemo {

    public static void main(String[] args) {

        //xml
        ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context1.getBean("student");
        student.getMessage();

        //Component annotation
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(Student1Config.class);
        Student1 student1 = context2.getBean(Student1.class);
        student1.getMessage();
        context2.close();

        //Bean annotation
        AnnotationConfigApplicationContext context3 = new AnnotationConfigApplicationContext(Student2Config.class);
        Student2 student2 = context3.getBean(Student2.class);
        student2.getMessage();
        context3.close();

    }
}
