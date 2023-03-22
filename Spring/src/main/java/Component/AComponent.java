package Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
 *
 * @author SUN
 * @date 2023/03/22  21:22
 */
@Component
public class AComponent {
    @Autowired
    private BComponent bComponent;
    @PostConstruct
    public void postConstruct(){
        System.out.println("ִ����a�� @PostConstruct");
    }
}
