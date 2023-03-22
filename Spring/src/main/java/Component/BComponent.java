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
 * @date 2023/03/22  21:23
 */
@Component
public class BComponent {
    @Autowired
    private CComponent component;

    @PostConstruct
    public void postConstruct(){
        System.out.println("ִ����b�� @PostConstruct");
    }
}
