package Controller;

import Model.User;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
 *
 * @author SUN
 * @date 2023/03/22  16:51
 */
@Controller
public class UserAdviceController {
    @Resource
    private User user1;

    public  void getUser(){
        System.out.println("���� | user1:"+user1.toString());
    }


}
