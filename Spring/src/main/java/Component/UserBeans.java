package Component;

import Model.User;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/22  16:19
 */
@Component
public class UserBeans {
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public User user1(){
        User user=new User();
        user.setId(1);
        user.setName("张三");
        user.setPassword("123");
        return user;
    }


}
