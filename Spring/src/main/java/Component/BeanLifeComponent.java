package Component;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
 *
 * @author SUN
 * @date 2023/03/22  20:50
 */
//@Component
public class BeanLifeComponent implements BeanNameAware {

    @Override
    public void setBeanName(String s) {
        System.out.println("ִ����֪ͨ");
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("ִ����@PostConstruct");
    }
    public  void init(){
        System.out.println("ִ����init-method����");
    }
    @PreDestroy
    public void preDestory(){
        System.out.println("ִ�����ٷ���");
    }
}
