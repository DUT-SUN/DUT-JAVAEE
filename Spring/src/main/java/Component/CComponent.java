package Component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
 *
 * @author SUN
 * @date 2023/03/22  21:24
 */
@Component
public class CComponent {
    @PostConstruct
    public void postConstruct(){
        System.out.println("ִ����c�� @PostConstruct");
    }
}
