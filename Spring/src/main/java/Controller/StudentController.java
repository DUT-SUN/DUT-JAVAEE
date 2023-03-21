package Controller;

import Component.StudentBeans;
import Model.Student;
import Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
 *
 * @author SUN
 * @date 2023/03/21  18:29
 */
@Controller
public class StudentController {

    //1.2������ע��final�����о�������Υ����һ���ԭ��

    //1.ʹ������ע��ķ�ʽ��ȡBean
//    @Autowired
//    private final StudentService  studentService;
//    private StudentBeans studentBeans;
//2.Set����ע��
//@Autowired
//    public void setStudentService(StudentService studentService) {
//        this.studentService = studentService;
//    }
//3.���췽��ע��
// ǰ���ַ���������ʷ���������޷�ȥע��final���󣬵���final�����ǿ���ֱ�Ӹ�ֵ���߹��캯���и�ֵ�ģ�����ǿ��Եģ�����ȥΥ��JDK�ĵײ�

    //��ֻ��һ�����캯����ʱ�򣬲���д���ע�⣬��������2����Ҫ�ģ�Ȼ��Spring4.x֮���Ƽ�ʹ�ù��췽��ע��
    //����ʹ������ע�뻹����������Ϊ�򵥣���Ϊ���Բ�ʹ��final���Ҿ���Spring��IOC������
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
//        //ע�����
//        studentService.sayHi();
//    }

    //@Resource���@AUTOwired���Բ������࣬����ȷ��ȥѡ��bean���󣬺���ֻ��require����
    //����@Autowired����ͨ�����ַ�������ȷѡ��bean����һ���Ǹ�����������ĸСд�ķ���������ͬ����ѡ��
    //����һ�ַ�ʽ�����ע��    @Qualifier("student1")
//@Resource(name = "student2")
    @Autowired
    @Qualifier("student1")
   private Student student;
public void sayHi(){
    System.out.println(student.toString());
}



}
