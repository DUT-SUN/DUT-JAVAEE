package ioc;



/**
 * ��������
 * <p>
 * �������أ������ٳ�
 *
 * @author SUN
 * @date 2023/03/13  23:14
 */
public class App {
    public static void main(String[] args) {
        Tire tire=new Tire(15);
        Bottom bottom=new Bottom(tire);
        Framework framework=new Framework(bottom);
        Car car=new Car(framework);
        car.init();

    }
}
