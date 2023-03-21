package Controller;

import Component.StudentBeans;
import Model.Student;
import Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/21  18:29
 */
@Controller
public class StudentController {

    //1.2都不能注入final对象还有就是容易违背单一设计原则

    //1.使用属性注入的方式获取Bean
//    @Autowired
//    private final StudentService  studentService;
//    private StudentBeans studentBeans;
//2.Set方法注入
//@Autowired
//    public void setStudentService(StudentService studentService) {
//        this.studentService = studentService;
//    }
//3.构造方法注入
// 前两种方法由于历史遗留问题无法去注入final对象，但是final对象是可以直接赋值或者构造函数中赋值的，这就是可以的，不会去违背JDK的底层

    //当只有一个构造函数的时候，不用写这个注解，但是这有2个需要的，然后Spring4.x之后推荐使用构造方法注入
    //但是使用属性注入还是主流（因为简单，因为可以不使用final并且就用Spring（IOC容器）
//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    public StudentController(StudentService studentService, StudentBeans studentBeans) {
//        this.studentService = studentService;
//        this.studentBeans = studentBeans;
//    }
//
//    public void sayHi(){
//        //注入服务
//        studentService.sayHi();
//    }

    //@Resource相比@AUTOwired可以参数更多，更精确的去选择bean对象，后者只有require属性
    //但是@Autowired可以通过两种方法来精确选择bean对象，一种是根据他们首字母小写的方法名（不同）来选择
    //还有一种方式是添加注解    @Qualifier("student1")
//@Resource(name = "student2")
    @Autowired
    @Qualifier("student1")
   private Student student;
public void sayHi(){
    System.out.println(student.toString());
}



}
