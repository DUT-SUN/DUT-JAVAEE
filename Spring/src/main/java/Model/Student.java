package Model;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
 *
 * @author SUN
 * @date 2023/03/21  10:56
 */
public class Student {
    private int Id;
    private int Age;
    private String Name;

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Age=" + Age +
                ", Name='" + Name + '\'' +
                '}';
    }
}
