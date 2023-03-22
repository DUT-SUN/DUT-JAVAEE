package Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
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
        System.out.println("执行了b的 @PostConstruct");
    }
}
