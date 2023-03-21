package Component;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/21  9:49
 */
@Component
public class UserComponent {
    public void sayHi(){
        System.out.println("Hi@Component");
    }

}
