package ioc;



/**
 * ��������
 * <p>
 * �������أ������ٳ�
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
        System.out.println("ִ����car��init����");
        framework.init();
    }
}
