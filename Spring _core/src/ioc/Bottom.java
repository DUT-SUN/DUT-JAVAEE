package ioc;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
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
        System.out.println("ִ��bottom�ĳ�ʼ��");
        tire.init();
    }
}
