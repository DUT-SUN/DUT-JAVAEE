package Controller;

import Model.User;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/22  16:51
 */
@Controller
public class UserAdviceController {
    @Resource
    private User user1;

    public  void getUser(){
        System.out.println("王五 | user1:"+user1.toString());
    }


}
