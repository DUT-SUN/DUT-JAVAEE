package Component;

import Model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/21  10:57
 */
@Component
public class StudentBeans {
    @Bean(name={"s1","s2"})
    public Student student(){
        Student stu=new Student();
        stu.setId(1);
        stu.setName("霍哥");
        stu.setAge(20);
        return stu;
    }

}
