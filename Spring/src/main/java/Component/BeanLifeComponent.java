package Component;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/22  20:50
 */
//@Component
public class BeanLifeComponent implements BeanNameAware {

    @Override
    public void setBeanName(String s) {
        System.out.println("执行了通知");
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("执行了@PostConstruct");
    }
    public  void init(){
        System.out.println("执行了init-method方法");
    }
    @PreDestroy
    public void preDestory(){
        System.out.println("执行销毁方法");
    }
}
