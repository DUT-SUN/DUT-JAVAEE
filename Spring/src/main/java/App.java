import Component.StudentBeans;
import Component.User;
import Component.UserComponent;
import Controller.StudentController;
import Model.Student;
import Service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
 *
 * @author SUN
 * @date 2023/03/15  10:24
 */
//ApplicationContext�̳���BeanFactory��ǰ��һ���Լ���������bean���������õ��ĸ������ĸ�
public class App {
    public static void main(String[] args) {
        //1.�ȵõ�spring����
//        BeanFactory context=new XmlBeanFactory(new ClassPathResource("spring-config.xml"));

//        System.out.println("������Spring����");
//        (1)
        //������Spring����
        //ִ����User�Ĺ��췽��
        //hello,world
        //hello,world
        //true

        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
//        (2)
//        ִ����User�Ĺ��췽��
//        ������Spring����
//        hello,world
//        hello,world
//        true
        //2.��spring��ȡ��bean����
//        System.out.println("������Spring����");
//        User user=(User) context.getBean("user");
//        System.out.println(user.sayHi());
//        //������ͬһ���࣬����bean��id��ͬ��������ֱ�ȡ��������Ҳ����ȵ�
//        User user1=context.getBean(User.class);
//        System.out.println(user1.sayHi());
//        System.out.println(user==user1);//true
//        //��Ϊȡ�����Ķ���������ͬһ�����������ڿ��������У�ͬһ����ֱ����ڲ�ͬ������Ҫ��������bean��ͬid
//        //��ôʹ��User.class�޷�ȥȷ�����ĸ�id��bean
//        //���Բ�ȡ�������ֳ����ķ�����ȡ�����еĶ���
//        User user3=context.getBean("user",User.class);
//        UserComponent component=context.getBean("userComponent",UserComponent.class);
//        component.sayHi();
//       Student student=context.getBean("s1",Student.class);
//        System.out.println(student);
        StudentController studentController=context.getBean("studentController",StudentController.class);
        studentController.sayHi();
    }
}
