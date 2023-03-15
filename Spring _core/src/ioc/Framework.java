package ioc;



/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/13  23:14
 */
public class Framework {
    private ioc.Bottom bottom;
        public  Framework(ioc.Bottom bottom) {
       this.bottom=bottom;
    }
    public void init(){
        System.out.println("执行了Framework的init方法");
        bottom.init();

    }
}
