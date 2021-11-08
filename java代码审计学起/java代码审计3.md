---
title: java代码审计3
tags:
  - java
categories:
  - java代码审计
description: "二进制到汇编学习！DOcker"
top_img: /2.jpg
cover: /image/buu.png
password: sm1le
date: 2021-11-05 10:37:46
top:
---



# 二进制到汇编学习



## 学习目标

![image-20211105104034550](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105104034.png)





![image-20211105104702922](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105104703.png)





## Docker

![image-20211105150350558](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105150350.png)

Docker 是为了把环境配好！直接运行！



![image-20211105152627098](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105152627.png)

### 容器技术

![image-20211105152616936](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105152617.png)



Docker为什么更快！

![image-20211105160701970](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105160702.png)

Docker用服务器的内核！ 再加上（需要的lib库和应用）容器！ 

### Docker镜像加载原理

![image-20211105175014005](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211105175014005.png)



![image-20211105175005787](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211105175005787.png)

直接用我们服务器上的 `bootfs`内核   。

 只不过`rootfs`变了！ ！  变成 `ub` `ct` 红帽等！

### 分层理解

![image-20211105175757044](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105175757.png)



![image-20211105175908429](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105175908.png)

### 一层一层的安装！

![image-20211105175947860](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105175947.png)

比如`centos`安装过了！它就不会再安装了！



![image-20211105180044297](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105180044.png)



![image-20211105181141361](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105181141.png)



![image-20211105181245342](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105181245.png)

每层最后合并一起 ！ 

![image-20211105181309648](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105181309.png)

每次PULL是分层下载的！



![image-20211105181643613](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105181643.png)

就是run的时候 相当于在原来的之上再填上一层！ 

然后我们可以打包自己的镜像了！



### commit镜像

生成自己的镜像



![image-20211106090300101](https://gitee.com/taochiyu/blogimage/raw/master/img/20211106090300.png)

### 容器卷

![image-20211106090520585](https://gitee.com/taochiyu/blogimage/raw/master/img/20211106090520.png)



#### 几种挂载方式

![image-20211106091301741](https://gitee.com/taochiyu/blogimage/raw/master/img/20211106091301.png)



#### 容器数据卷

![image-20211106093626931](https://gitee.com/taochiyu/blogimage/raw/master/img/20211106093627.png)



### DockerFile

![image-20211106092127225](https://gitee.com/taochiyu/blogimage/raw/master/img/20211106092127.png)





![image-20211106094540298](https://gitee.com/taochiyu/blogimage/raw/master/img/20211106094540.png)

#### 指令

![image-20211106101028668](https://gitee.com/taochiyu/blogimage/raw/master/img/20211106101028.png)

![image-20211106101232856](https://gitee.com/taochiyu/blogimage/raw/master/img/20211106101232.png)

编写`dockerfile`

![image-20211106104502665](https://gitee.com/taochiyu/blogimage/raw/master/img/20211106104502.png)



```shell
FROM centos
MAINTAINER upload

ENV MYPATH /usr/local
WORKDIR $MYPATH

RUN yum -y install vim
RUN yum -y install net-tools

EXPOSE 80

CMD echo $MYPATH
CMD echo "-------end------"
CMD /bin/bash
```



#### 发布镜像

![image-20211106124705567](https://gitee.com/taochiyu/blogimage/raw/master/img/20211106124705.png)



## docker总结图

![image-20211106125319146](https://gitee.com/taochiyu/blogimage/raw/master/img/20211106125337.png)



## Docker网络

