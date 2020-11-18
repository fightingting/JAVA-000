package beanAnnotationDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangtingting
 * @date 2020-11-18 15:48
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
@Configuration
public class Student2Config {

    @Bean
    public Student2 getStudent(){
        return  new Student2();
    }
}
