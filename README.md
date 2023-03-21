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
