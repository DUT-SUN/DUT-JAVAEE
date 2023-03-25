# DUT-JAVAEE
JAVAEE进阶学习<br/>
Spring
====
Spring：一个包含众多工具方法的IOC容器<br/>
IOC控制反转（反转的是对象的生命周期控制权，意思是我不用再new再去管理构造链上的底层对象的构造了）<br/>
JVAA进阶约定：<br/>
数据库：使用mysql 5.7.x<br/>
JDK版本 JDK8<br/>
IOC是思想，DI是实现<br/>
DI：依赖注入，就像原本的new改为将依赖的类对象注入到参数列表的那种意思<br/>

getbean的时候如何根据类名去取bean对象（传什么别名）<br/>
通过看Spring源码发现Spring调用了jdk的一个函数decapitalize他来帮判断
````
    public static String decapitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        if (name.length() > 1 && Character.isUpperCase(name.charAt(1)) &&
                        Character.isUpperCase(name.charAt(0))){
            return name;
        }
        char chars[] = name.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }
````
简单来说就是假如你创建的类名第一个字母是小写，那么返回的就是这个类名为别名  
假如你创建的类名第一个字母大写，第二个字母小写，那么返回的就是这个类名首字母小写  
假如你创建的类名是第一个字母大写，第二个字母大写，那么返回的就是这个类名！！！！！  

五大类注解的作用
@Controller(控制器)：归属于业务逻辑层，用来控制用户的行为，用来检查参数的有效性  
@Service(服务):归属于服务层，调用持久化类实现相应的功能（不直接操作数据库）  
@Repository(仓库):归属于持久层，直接与数据库打交道，通常每个表对应一个repository    
@Configuration(配置):归属于配置层，用来配置项目的信息  
@Component(组件)：归属于公共工具类，提供某些公共方法    

Bean的作用域：Bean在Spring框架下的某种行为模式  
#Bean的六种作用域：  
singleton（单例作用域）单例模式  
prototype(原型作用域）多例模式  
request(请求作用域）每次请求创一个  
session（回话作用域）每次会话创一个     ->多线程中的ThreadLocal  
application（全局作用域）一个context里是共享的，多个不是共享的  
websocket 一个HTTP websocket生命周期只有一个Bean实例  


singleton和application的不同

singleton是spring core的作用域   
application是Springweb中的作用域  

singleton是作用于IOC容器
而application是作用于Servlet容器

说一下Spring的执行流程？  
1.启动容器（项目）  
2.读取配置文件初始化  
（a）使用xml直接注册bean  
（b）配置bean根扫描路径  
3.将bean存储到spring中通过类注解进行扫描和装配  
4.将bean从spring读取出来装配到相应的类  

Bean生命周期：  
1.实例化（对应JVM中的加载）分配了内存  
2.设置属性（Bean注入和装配）  
3.初始化  
（a）各种通知  
（b）初始化的前置工作  
（c）进行初始化工作【使用注解@PostConstruct初始化，使用（xml）init-method初始化】//假如两个都有的话，前者先执行  
（d）初始化后的后置工作  
4.使用bean  


SpringBoot  
====
概念：它是Spring的脚本架，为了简化Spirng的开发  
SpringBoot核心：  
1.快速添加依赖  
2.内置web容器  
3.提供了自动装配  

yml和properties都是配置文件  
yml中的中文通过@Value拿到数据的时候不会是乱码  
student: {id: 12,name: 牛马,age: 666}  
去配置对象  
@Component  
@ConfigurationProperties("student")  
@Data  
public class Student {  
    private int id;  
    private String name;  
    private int age;  
}  
这样去自动初始化对象的值,注意这里面的属性值要和配置的一样  

日志文件  
使用日志：
1.得到日志对象  
2.打印日志  
