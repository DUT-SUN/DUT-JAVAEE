package Component;

import org.springframework.stereotype.Controller;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
 *
 * @author SUN
 * @date 2023/03/15  10:24
 */
@Controller
public class User {
    public User(){
        System.out.println("ִ����User�Ĺ��췽��");
    }

    public String sayHi(){
        return "hello,world";
    }
}
