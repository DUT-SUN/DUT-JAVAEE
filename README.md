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

  //1.得到日志对象  
    private static final Logger logger=LoggerFactory.getLogger(UserController.class);  
  //2.写日志
  
        logger.trace("我是trace");  
        logger.debug("我是调试日志");  
        logger.info("我是info");  
        logger.error("我是error");  
        logger.warn("我是warn");  
                     日志级别|线程id      线程名          c是com简写以此类推      包名+类名   
2023-03-25 15:08:19.316  INFO 26368 --- [nio-8888-exec-1] c.e.s.Controller.UserController          : 我是info  
2023-03-25 15:08:19.316 ERROR 26368 --- [nio-8888-exec-1] c.e.s.Controller.UserController          : 我是error  
2023-03-25 15:08:19.316  WARN 26368 --- [nio-8888-exec-1] c.e.s.Controller.UserController          : 我是warn  

日志持久化  以及全局部分等级设置
logging:   
  file:  
    path: E:\DUT-JAVAEE\SpringBoot_First\src\main\java\com\example\springboot_first\logs  
  level:  
    root: error  
    com:  
      example:  
        springboot_first:  
          Controller: trace  
     
@SLF4J可以添加一个名为log的日志

SpringMVC
====
//3种路由
@PostMapping("/hi")  
@GetMapping("/showuser")
@RequestMapping(value = "/hi",method = RequestMethod.POST)  

   @GetMapping("/showuser")  
    public String showUser(User user){  
        return user.toString();  
    }  
    http://localhost:8080/test/showuser?id=1&name=%E5%BC%A0%E4%B8%89&age=666  

前端的吊毛乱传参数名时？怎么解决  
—— public  String getTime(@RequestParam("t1") String startTime,@RequestParam("t2") String endTime)  

@RequestBody 解析json对象  
 @PostMapping("/getUser")  
    public String getUser(@RequestBody User user){  
        return user.toString();  
    }  
Mybatis的xml模板  
<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">  
<mapper namespace="com.example.demo.mapper.UserMapper">  
   
</mapper>  
    
Junit进行单元测试  
    @SpringBootTest  
class UserMapperTest {  
@Autowired  
private UserMapper userMapper;  
    @Test  
    void getUserById() {  
        Userinfo userinfo=userMapper.getUserById(1);  
        System.out.println(userinfo);  
        Assertions.assertEquals("admin",userinfo.getUsername());  
    }  
}  

```
@Test
    void add2() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("123");
        userinfo.setPassword("123");
        userinfo.setCreatetime(LocalDateTime.now());
        userinfo.setUpdatetime(LocalDateTime.now());
        //调用mybatis添加方法
        int result= userMapper.add2(userinfo);//返回的是受影响的行数
        System.out.println("添加: "+result);
        int id=userinfo.getId();//这个是用下面框架提供的两个属性自动将主键返回的值写入id中，我们通过getid获取
        System.out.println("ID："+id);
    }
```

返回插入字段的id  
```
   <insert id="add2" useGeneratedKeys="true" keyProperty="id">
        insert into userinfo(username,password,createtime,updatetime)
        values(#{username},#{password},#{createtime},#{updatetime})
    </insert>
```
#{}和${}使用辨析  
#是预编译，在执行的时候是将实际的值通过识别看是否需要加双引号什么的去替换？  
$是直接替换  

大部分情况用#，因为比如更新字段的时候通过username更新，${}直接替换会导致传的字符串不带""所以sql语句识别不出来  
少部分只能用$还不能用#:就是当排序的时候，desc这样的是mysql的关键字，不能用#否则#识别出来你要传的是字符串加了""反而导致出现错误  

SQL注入攻击

```
    @Test
    void login() {
        String username="admin";
        String password="' or 1='1";
        Userinfo userinfo=userMapper.login(username,password);
        System.out.println("登录状态:"+((userinfo==null)?"登录失败":"登录成功"));
    }
```
------------------------------------------------------------------
```
==>  Preparing: select * from userinfo where username='admin' and password='' or 1='1'
==> Parameters: 
<==    Columns: id, username, password, photo, createtime, updatetime, state
<==        Row: 1, admin, admin, , 2021-12-06 17:10:48, 2021-12-06 17:10:48, 1
<==        Row: 2, 123, 123, , 2023-03-27 18:27:38, 2023-03-27 18:27:38, 1
<==        Row: 3, 123, 123, , 2023-03-27 18:28:46, 2023-03-27 18:28:46, 1
<==        Row: 4, 123, 123, , 2023-03-27 18:30:30, 2023-03-27 18:30:30, 1
<==        Row: 5, 涛哥, 123, , 2023-03-27 18:49:29, 2023-03-27 18:49:29, 1
<==        Row: 6, 123, 123, , 2023-03-27 18:49:53, 2023-03-27 18:49:53, 1
<==        Row: 7, 123, 123, , 2023-03-27 18:51:53, 2023-03-27 18:51:53, 1
<==        Row: 8, 123, 123, , 2023-03-27 18:52:00, 2023-03-27 18:52:00, 1
<==      Total: 8
```

Spring AOP
====
概念：他是对某一类事件的集中处理  
AOP：面向切面编程  
1.用户登录  
2.统一日志记录  
3.统一方法的执行时间    
4.统一返回格式设置    
5.统一异常处理  
6.事务的开启和提交  


