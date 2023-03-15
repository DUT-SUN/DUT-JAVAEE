package old;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/13  22:45
 */
 class Framework {
    private Bottom bottom;
    public  Framework(){
        bottom=new Bottom();
    }
    public void init(){
        System.out.println("执行了Framework的init方法");
        bottom.init();

    }
}
