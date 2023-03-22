package Controller;

import Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/22  16:48
 */
@Controller
public class UserController {
    @Autowired
   private User user1;

    public void getUser(){
        System.out.println("user1:"+user1.toString());
        User u=user1;
        u.setName("李四");
        System.out.println("u:"+u.toString());
    }
}
