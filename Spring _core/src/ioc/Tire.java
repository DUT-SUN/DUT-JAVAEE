package ioc;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
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
        System.out.println("ִ������̥�ĳ�ʼ������"+this.size);
    }
}
