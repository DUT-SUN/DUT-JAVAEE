package Controller;

import Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
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
        u.setName("����");
        System.out.println("u:"+u.toString());
    }
}
