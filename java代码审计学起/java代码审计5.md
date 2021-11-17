---
title: java代码审计4
tags:
  - javaweb
categories:
  - java代码审计
description: "进入javaweb阶段"
top_img: /2.jpg
cover: /image/buu.png
password: sm1le
date: 2021-11-08 16:49:09
top:

---



## javaweb

![image-20211111095343050](https://gitee.com/taochiyu/blogimage/raw/master/img/20211111095350.png)

### tomcat

![image-20211110212151622](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110212151.png)

访问一个域名的过程

![image-20211110214412940](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110214423.png)



### Maven

```shell
	<mirror>
		<id>nexus-aliyun</id>
		<mirrorOf>central</mirrorOf>
		<name>Nexus aliyun</name>
		<url>http://maven.aliyun.com/nexus/content/groups/public</url>
	</mirror>
  </mirrors>
```



```shell
 <localRepository>D:/apache-maven-3.8.1/bao</localRepository>
```



### Servlet

#### 结构

![image-20211111111714899](https://gitee.com/taochiyu/blogimage/raw/master/img/20211111111715.png)

#### mapping

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

    <servlet>
        <servlet-name>upload_ilscy</servlet-name>
        <servlet-class>com.upload.ilscy.Servlet01</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>upload_ilscy</servlet-name>
        <url-pattern>/upload_ilscy</url-pattern>
    </servlet-mapping>
</web-app>
```



#### ServletConfig接口

![image-20211111161655658](https://gitee.com/taochiyu/blogimage/raw/master/img/20211111161655.png)









## javase补充

### 集合

#### 集合概述

By [小猴子1024](http://www.monkey1024.com/author/admin) |

[0 Comment](http://www.monkey1024.com/javase/528#respond)

#### 集合的由来

数组长度是固定,如果要改变数组的长度需要创建新的数组将旧数组里面的元素拷贝过去，使用起来不方便。
java给开发者提供了一些`集合类`，`能够存储任意长度的对象`，长度可以随着元素的增加而增加,随着元素的减少而减少，使用起来方便一些。



#### MAP

![image-20211111214157829](https://gitee.com/taochiyu/blogimage/raw/master/img/20211111214157.png)



### 反射

又来理解一遍！

反射就是

反射机制是在程序运行状态中，对于任意一个类，都能够**获取这个类的所有属性和方法；**
对于任意一个对象，**都能够调用它的任意一个方法和属性；**

#### Class对象

在类加载器将.class文件读取到内存中的时候，jvm会创建这个.class文件的对象，并且对每个class文件只创建一个对象存放到jvm的方法区内存中，在java.lang包下有个Class类，这个类就是.class文件的对象类型，**任何类在被使用时，都会创建这个类的Class对象**。除此之外，在java.lang.reflect包下面的类也跟反射有关。



**任何类在被使用时，都会创建这个类的Class对象**



获取这个类的所有属性和方法；

调用对象的任意一个方法和修改属性；

##### 使用反射获取类中指定的属性并赋值      我这里把它说出调用对象的属性并赋值 因为我理解的 它这里创建对象了！

```java
package com.upload.scy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;

import com.upload.scy.Person;
/**
 * Created by upload on 2021/11/11.
 */
public  class TestJava {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("com.upload.scy.Person");
        /*//获取指定属性的Field对象
        Field f = c.getDeclaredField("name");
        //创建对象
        Object o = c.newInstance();

        //给o对象上的name属性赋值为张三
        f.set(o, "张三");
        //获取o对象上的name属性的值
        System.out.println(f.get(o));*/

        Field f = c.getDeclaredField("age");
        System.out.println(f);
        Object o = c.newInstance(); // 创建对象
        //从外部打破封装性
        f.setAccessible(true);
        f.set(o, 20);
        System.out.println(f.get(o));
    }
}
```



##### 使用反射调用类中的方法   我理解成调用对象的方法

```java
package com.upload.scy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import com.upload.scy.Person;
/**
 * Created by upload on 2021/11/11.
 */
public  class TestJava {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class c = Class.forName("com.upload.scy.User");
        //获取方法
        Method method = c.getDeclaredMethod("m5", String.class, int.class);
        //创建对象
        Object o = c.newInstance();
        Object result = method.invoke(o, "admin", 10);
        System.out.println(result);
    }

}

```

`http://www.monkey1024.com/javase/702`



#### 使用反射读取配置文件示例

框架里用的多！



## JSP



**JSP就是一个servlet**

### JSP的工作流程

将JSP文件转换为.java文件并将其编译为.class文件的过程都是由tomcat完成的，在tomcat内部有一个翻译引擎，当JSP页面**第一次**被访问时由翻译引擎转换为.java文件并编译出.class文件。之后再运行该class文件。
在JSP中的html代码都会翻译到servlet中的out.write()中。



## MVC



### mvc开发模式简介

M: Model模型 JavaBean
V：view视图 JSP
C:Controller控制器 Servlet



![image-20211112130739603](https://gitee.com/taochiyu/blogimage/raw/master/img/20211112130739.png)



![image-20211112141642235](https://gitee.com/taochiyu/blogimage/raw/master/img/20211112141655.png)



![image-20211112154127596](https://gitee.com/taochiyu/blogimage/raw/master/img/20211112154127.png)



![image-20211112154520463](https://gitee.com/taochiyu/blogimage/raw/master/img/20211112154520.png)

## 过滤器

```java
package com.upload.scy.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by upload on 2021/11/12.
 */
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤请求");
        //通过过滤器继续访问资源
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;chartset=UTF-8");
        System.out.println("aaaaaaaaaa");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("ada");

    }
    @Override
    public void destroy() {

        System.out.println("destory");
    }
}

```



## 监听器

```java

```





## SSM

![image-20211112213054605](https://gitee.com/taochiyu/blogimage/raw/master/img/20211112213054.png)





# 文章

`http://www.monkey1024.com/javaweb/897`

`http://www.bjpowernode.com/servlet/`





# 问题



## 对象（object）和实例（instance）有区别吗？



