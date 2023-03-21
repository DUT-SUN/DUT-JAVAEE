import Component.StudentBeans;
import Component.User;
import Component.UserComponent;
import Controller.StudentController;
import Model.Student;
import Service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/15  10:24
 */
//ApplicationContext继承于BeanFactory，前者一次性加载了所有bean，后者是用到哪个加载哪个
public class App {
    public static void main(String[] args) {
        //1.先得到spring对象
//        BeanFactory context=new XmlBeanFactory(new ClassPathResource("spring-config.xml"));

//        System.out.println("创建了Spring对象");
//        (1)
        //创建了Spring对象
        //执行了User的构造方法
        //hello,world
        //hello,world
        //true

        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
//        (2)
//        执行了User的构造方法
//        创建了Spring对象
//        hello,world
//        hello,world
//        true
        //2.从spring中取出bean对象
//        System.out.println("创建了Spring对象");
//        User user=(User) context.getBean("user");
//        System.out.println(user.sayHi());
//        //就算是同一个类，两个bean中id不同，在这里分别取出，他们也不相等的
//        User user1=context.getBean(User.class);
//        System.out.println(user1.sayHi());
//        System.out.println(user==user1);//true
//        //因为取出来的都是容器中同一个对象，所以在开发过程中，同一对象分别用于不同程序，需要创建两个bean不同id
//        //那么使用User.class无法去确认是哪个id的bean
//        //所以采取下列这种常见的方法获取容器中的对象
//        User user3=context.getBean("user",User.class);
//        UserComponent component=context.getBean("userComponent",UserComponent.class);
//        component.sayHi();
//       Student student=context.getBean("s1",Student.class);
//        System.out.println(student);
        StudentController studentController=context.getBean("studentController",StudentController.class);
        studentController.sayHi();
    }
}
