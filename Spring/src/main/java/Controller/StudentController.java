package Controller;

import Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
    //1.使用属性注入的方式获取Bean
    @Autowired
    private StudentService studentService;
    public void sayHi(){
        //注入服务
        studentService.sayHi();
    }
}
