---
title: java代码审计1
tags:
  - java
categories:
  - java代码审计
description: "反射学习"
top_img: /2.jpg
cover: /image/buu.png
password: sm1le
date: 2021-10-31 16:49:36
top:
---



## 动静态语言

![image-20211031164959948](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031165857.png)



![image-20211031165015753](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031165909.png)



## 反射

![image-20211031170105652](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031170105.png)



就是先创建一个Class对象！ 只不过这个Class对象里放着是目标类的全部信息！



![image-20211031172318641](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031172318.png)



## Class类

![image-20211031172415085](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031172415.png)

`java`里的类 都是从 Class创建的！ 



![image-20211031173123893](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031173124.png)

## Class常用方法

![image-20211031173828936](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031173829.png)



## Class类的创建方式

**Class类的对象就一个！**



![image-20211031181132607](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031181132.png)



## 有哪些类型有Class对象

![image-20211031181343156](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031181343.png)



![image-20211031182756886](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031182757.png)



## java内存



![image-20211031182849246](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031182849.png)

### 类的加载过程1

![image-20211031183755028](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031183755.png)

### 类的加载过程2

![image-20211031184554197](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031184554.png)

创建Test05类后！ 运行后！堆里就生成了Class对象！ 它代表着Test05类！有Test05类全部东西！



当new A对象时也是去从Class对象里 找的数据！

### 类的加载与ClassLoader的理解

![image-20211031185813712](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031185813.png)

![image-20211031185701266](https://gitee.com/taochiyu/blogimage/raw/master/img/20211031185701.png)



### 类的初始化



![image-20211101093219926](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101093227.png)



### 类加载器

![image-20211101093743309](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101093743.png)



![image-20211101094505946](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101094506.png)



## 创建运行时类的对象



![image-20211101094639926](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101094640.png)

## 获取到Class对象，能做什么 ！（反射思想）



![image-20211101190127266](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101190127.png)

### 创建user对象！

#### 获取user类的构造器！



![image-20211101191052114](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101191109.png)



![image-20211101190409568](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101190415.png)



### 获取一个方法

![image-20211101190625045](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101190840.png)

![image-20211101191330032](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101191330.png)

![image-20211101191453608](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101191501.png)



![image-20211101191512543](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101191529.png)

![image-20211101191634846](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101191703.png)



## 反射操作泛型

![image-20211101204948060](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101204948.png)



## 反射操作注解

### ORM 

对象映射成表！

![image-20211101205906375](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101205906.png)



![image-20211101210012038](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101210012.png)





## 总结



![image-20211101210227393](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101210258.png)



学习地址！

`https://www.bilibili.com/video/BV1p4411P7V3?p=17&spm_id_from=pageDriver`







![image-20211101210628048](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101210628.png)







