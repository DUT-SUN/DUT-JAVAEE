package old;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/13  22:46
 */
public class Bottom {
    private Tire tire;
    public Bottom(){
        tire=new Tire();
    }
    public void init(){
        System.out.println("执行了tire的init方法");

        tire.init();

    }
}
