package old;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
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
        System.out.println("ִ����Framework��init����");
        bottom.init();

    }
}
