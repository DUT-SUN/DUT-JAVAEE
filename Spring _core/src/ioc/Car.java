package ioc;



/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/13  23:14
 */
public class Car {
    private ioc.Framework framework;
    public  Car(ioc.Framework framework){
        this.framework=framework;
    }
    public void init(){
        System.out.println("执行了car的init方法");
        framework.init();
    }
}
