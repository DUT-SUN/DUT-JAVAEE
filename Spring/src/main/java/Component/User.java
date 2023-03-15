package Component;

import org.springframework.stereotype.Controller;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/15  10:24
 */
@Controller
public class User {
    public User(){
        System.out.println("执行了User的构造方法");
    }

    public String sayHi(){
        return "hello,world";
    }
}
