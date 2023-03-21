package Component;

import Model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
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
        stu.setName("����");
        stu.setAge(20);
        return stu;
    }

}
