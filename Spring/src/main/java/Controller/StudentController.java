package Controller;

import Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
    //1.ʹ������ע��ķ�ʽ��ȡBean
    @Autowired
    private StudentService studentService;
    public void sayHi(){
        //ע�����
        studentService.sayHi();
    }
}
