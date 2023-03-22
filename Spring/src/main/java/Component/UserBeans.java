package Component;

import Model.User;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
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
        user.setName("����");
        user.setPassword("123");
        return user;
    }


}
