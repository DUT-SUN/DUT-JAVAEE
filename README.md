# DUT-JAVAEE
JAVAEE进阶学习<br/>
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

