package ioc;



/**
 * ��������
 * <p>
 * �������أ������ٳ�
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
        System.out.println("ִ����Framework��init����");
        bottom.init();

    }
}
