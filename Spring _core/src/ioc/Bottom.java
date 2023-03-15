package ioc;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/13  23:14
 */
public class Bottom {
    private ioc.Tire tire;


    public Bottom(ioc.Tire tire) {
        this.tire=tire;
    }

    public void init(){
        System.out.println("执行bottom的初始化");
        tire.init();
    }
}
