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
 * @date 2023/03/22  21:22
 */
@Component
public class AComponent {
    @Autowired
    private BComponent bComponent;
    @PostConstruct
    public void postConstruct(){
        System.out.println("执行了a的 @PostConstruct");
    }
}
