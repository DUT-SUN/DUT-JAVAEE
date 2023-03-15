package ioc;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/13  23:14
 */
public class Tire {
    public int size=20;

    public Tire(int i) {
        this.size=i;
    }

    public void init(){
        System.out.println("执行了轮胎的初始化方法"+this.size);
    }
}
