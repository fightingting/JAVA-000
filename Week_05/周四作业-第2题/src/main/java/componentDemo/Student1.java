package componentDemo;

import org.springframework.stereotype.Component;

/**
 * @author wangtingting
 * @date 2020-11-18 15:27
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
@Component
public class Student1 {

    public void getMessage(){
        System.out.println("Component annotation generate student");
    }
}
