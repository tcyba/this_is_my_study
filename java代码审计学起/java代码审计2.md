---
title: java代码审计2
tags:
  - java
categories:
  - java代码审计
description: "多线程"
top_img: /2.jpg
cover: /image/buu.png
password: sm1le
date: 2021-11-01 21:08:39
top:
---



# 多线程

## 目录

![image-20211101210940290](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101210940.png)

## 普通方法和多线程调用

![image-20211101211717569](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101211717.png)



## Thread类



![image-20211101213301352](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101213301.png)

### 案例

![image-20211101213433802](https://gitee.com/taochiyu/blogimage/raw/master/img/20211101213433.png)

### 代码

```java
package upload.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by upload on 2021/11/2.
 */
public class TestThread1 extends Thread{

    private String url;
    private String name;
    @Override
    public void run() {
       WebDownload wd = new WebDownload();
       wd.download(url,name);
        System.out.println("下载了文件名："+name);
    }

    public TestThread1(String name, String url) {
        this.url = url;
        this.name = name;
    }

    public static void main(String[] args) {
        TestThread1 t1 = new TestThread1("1.png","https://img-blog.csdnimg.cn/img_convert/3280522bccf52d8f0545589d931df8c0.png");
        TestThread1 t2 = new TestThread1("2.png","https://kuangstudy.oss-cn-beijing.aliyuncs.com/bbs/2021/02/20/kuangstudy8b4df11c-0086-4e43-b3d1-0a5c0bf91b94.png");
        TestThread1 t3 = new TestThread1("3.png","https://kuangstudy.oss-cn-beijing.aliyuncs.com/bbs/2021/02/20/kuangstudy6d92d690-5f04-4e66-8c5e-38b22f907a9d.png");
        t1.start();
        t2.start();
        t3.start();
    }

}

class WebDownload {
    public void download(String url,String file){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(file));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}
```



## Runnable接口 **

![image-20211102100716609](https://gitee.com/taochiyu/blogimage/raw/master/img/20211102100723.png)



**java是单继承 ** 推荐用多个接口

![image-20211103182626266](https://gitee.com/taochiyu/blogimage/raw/master/img/20211103182626.png)





### //多个线程操作同一个资源 翁乱

```java
package upload.thread;

/**
 * Created by upload on 2021/11/3.
 */

//多个线程操作同一个资源 翁乱
public class TestThread4 implements Runnable{

    private int ticketNums = 10;
    @Override
    public void run() {

        while (true){
            if (ticketNums<=0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--> 抢到第几张"+ticketNums--+"票");
        }

    }

    public static void main(String[] args) {
        TestThread4 t4 = new TestThread4();
        new Thread(t4,"陶驰宇").start();
        new Thread(t4,"邵彩银").start();
        new Thread(t4,"臭宝").start();
    }
}


```



### 龟兔

```java
package upload.thread;

/**
 * Created by upload on 2021/11/3.
 */
public class TestThread3 implements Runnable{

    private String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--> 跑路"+i+"步");
        }
    }

    private boolean gameOver (int steps){
        if (winner!=null){
            return true;
        }else {
            if (steps>=100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is + "+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TestThread3 t3 = new TestThread3();
        new Thread(t3,"陶驰宇").start();
        new Thread(t3,"邵彩银").start();
    }
}

```



## 静态代理模式



## lamda表达式

### 函数式接口

![image-20211104104352733](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104104352.png)



### 条件

![image-20211104105952688](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104105952.png)



## 线程的状态



![image-20211104110314562](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104110314.png)



### 线程方法

![image-20211104110356499](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104110356.png)

### 线程停止

![image-20211104110510634](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104110510.png)

### 线程休眠 sleep

![image-20211104111817702](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104111817.png)



### 线程礼让

**礼让不一定成功！还是看CPU的状态！**

![image-20211104112748154](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104112748.png)



### 线程强制执行 join

就是插队！ 先执行完join的！ 再执行别的！



### 线程优先级



![image-20211104120215660](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104120215.png)



## 守护线程



用户线程 `mian`

守护线程  `GU`  垃圾回收线程



![image-20211104121120965](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104121121.png)

## 线程同步 ** 



不安全的！ 

![image-20211104125549581](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104125549.png)



![image-20211104125627195](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104125627.png)



每个对象都有一把锁！！！🐱‍👓🐱‍👓🐱‍👓



加上synchronized 就好像访问的时候 一个一个访问！ 排队！ 



![image-20211104142910766](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104142910.png)



## 死锁

![image-20211104144939258](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104144939.png)



## LOCK锁

![image-20211104145833243](https://gitee.com/taochiyu/blogimage/raw/master/img/20211104145833.png)



## 线程通信



## 线程池

![image-20211105100258918](https://gitee.com/taochiyu/blogimage/raw/master/img/20211105100259.png)









