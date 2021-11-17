---
title: java代码审计4
tags:
  - nodejs
categories:
  - java代码审计
description: "直接进入javaweb阶段 nodejs js mysql"
top_img: /2.jpg
cover: /image/buu.png
password: sm1le
date: 2021-11-08 16:49:09
top:
---

## 先看看nodejs  大前端的东西

![image-20211108171429176](https://gitee.com/taochiyu/blogimage/raw/master/img/20211108171429.png)



## ES6

### let const

![image-20211108210806475](https://gitee.com/taochiyu/blogimage/raw/master/img/20211108210806.png)



### 模板字符串

![image-20211108211512747](https://gitee.com/taochiyu/blogimage/raw/master/img/20211108211512.png)

### 函数默认参数与箭头函数



![image-20211108212711107](https://gitee.com/taochiyu/blogimage/raw/master/img/20211108212711.png)



### 对象简写



![image-20211108213251121](https://gitee.com/taochiyu/blogimage/raw/master/img/20211108213251.png)



![image-20211108213612105](https://gitee.com/taochiyu/blogimage/raw/master/img/20211108213612.png)

### 对象解构

![image-20211108214029290](https://gitee.com/taochiyu/blogimage/raw/master/img/20211108214029.png)



### 对象传播操作符

![image-20211108214521202](https://gitee.com/taochiyu/blogimage/raw/master/img/20211108214521.png)



## npm



### package.json

![image-20211109141328259](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109141328.png)





## Bable

把ES6 转成ES5  降级处理！ 

![image-20211109140459046](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109140506.png)



![image-20211109140714062](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109140714.png)

需要再安装个编码器！



## CommonJs 规范

![image-20211109142109643](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109142109.png)

![image-20211109141908255](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109141908.png)

先导出 才能导入！ 

CommonJs规定的新语法！ 以前都是要全部粘过来才行！ 现在通过CommonJs的规范！ 直接导出 导入就可以了！ 



## ES6 规范



![image-20211109142705413](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109142705.png)



![image-20211109142713020](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109142713.png)



## WebPack

![image-20211109142940376](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109142940.png)

打包压缩 加密的一个模块！



合并js css



![image-20211109144420525](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109144420.png)

安全性 和性能 提升很大！ 





# javascript



字符串每个值不能变！

数组的长度可以变

![image-20211109161823794](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109161823.png)

## 数组方法

![image-20211109162249704](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109162249.png)

## 函数

### 函数定义

![image-20211109171840386](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109171840.png)



![image-20211109172509790](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109172509.png)

![image-20211109172454540](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109172454.png)



### 变量作用域



![image-20211109173251030](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109173251.png)



### window对象 

window对象就是全局对象

ES5 var 

ES6 let const



### 方法

把函数放到对象里 就是方法

![image-20211109180509690](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109180509.png)

```
upload['sss']()  调用方法
```

![image-20211109180515673](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109180515.png)

![image-20211109180521864](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109180521.png)



## 内部对象

### Date

![image-20211109181442050](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109181442.png)

### Json



![image-20211109182848946](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109182849.png)



## 面向对象编程

`javascript 万物皆对象`

### 原型

就可以理解成父类

```javascript
<script>
    'use strict'
    var upload = {
        name : 'ada22',
        sss:function (){
            console.log('adadad11111111')
        }

    }
    var sty = {
        name: 'adada'
    }
    sty.__proto__ = upload

</script>
</body>
</html>
```



以前定义个类

![image-20211109185546398](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109185546.png)

看以前的类我真的看不懂！ 

`https://www.ruanyifeng.com/blog/2012/07/three_ways_to_define_a_javascript_class.html`



现在的类

```javascript
<script>
    'use strict'

    class Person{

        constructor(name) {
            this.name = name;
        }
        hello(){
            alert('ada')
        }
    }

    class Stu extends Person{
        constructor(name,grade) {
            super();
            this.name= name;
            this.grade = grade;
        }
        aa(){
            alert('ssssssss')
        }
    }

    var tcy = new Stu('tcy','1')
    var scy = new Stu('scy','100')
    // tcy.aa()
</script>
</body>
</html>
```

### 原型链***  

它是一个环路！

![image-20211109191200106](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109191200.png)



![image-20211109191236361](https://gitee.com/taochiyu/blogimage/raw/master/img/20211109191236.png)



## Bom对象

B是浏览器 

![image-20211110093018747](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110093025.png)



### window()

### screen

### navigator

### location

代表当前页面URL的信息

![image-20211110094953437](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110094953.png)

![image-20211110095233782](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110095233.png)

### document

代表当前页面   获取当前页面的内容	



### history



## Dom对象

Dom 文档对象模型

![image-20211110100357835](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110100357.png)

### 获得Dom节点

![image-20211110100449252](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110100449.png)

### 操作Dom

![image-20211110102908965](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110102909.png)



![image-20211110105545879](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110105546.png)

### 操作表单

![image-20211110112806151](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110112806.png)



## JQuery

`https://jquery.cuishifeng.cn/text.html`

![image-20211110113604647](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110113604.png)



### 选中



### 事件



## 组件

Layer组件

element

bootstract

ANT Design





## 数据库 Mysql

这看到我晕晕的！ 不行了！不行了！我要快点进入javaweb了！不能再停下来了！

后年做毕设的时候我再来看这个数据库！

### 数据库引擎

Inodb my

### 事务

#### ACID 原则

![image-20211110181208212](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110181723.png)

![image-20211110181745554](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110181745.png)

这样就可以解决一些问题！（ACID） （防止有些语句提交了有些没提交！）

老师的案例：

![image-20211110181943696](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110181943.png)







### 索引

### 三大范式



### JDBC



### 数据库连接池



![image-20211110182945970](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110182946.png)



![image-20211110183031383](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110183031.png)

就是别人封装好了！ 

DBCP C3P0就是不用再像原始的一样写数据库连接了！ 

直接从配置文件里获取！

![image-20211110184007301](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110184007.png)



#### 数据源

![image-20211110184607392](https://gitee.com/taochiyu/blogimage/raw/master/img/20211110184607.png)





