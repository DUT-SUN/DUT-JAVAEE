package Component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/22  21:24
 */
@Component
public class CComponent {
    @PostConstruct
    public void postConstruct(){
        System.out.println("执行了c的 @PostConstruct");
    }
}
