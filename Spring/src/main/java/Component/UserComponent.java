package Component;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
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
