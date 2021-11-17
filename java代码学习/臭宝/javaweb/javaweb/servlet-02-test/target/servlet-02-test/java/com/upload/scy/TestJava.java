package com.upload.scy;

import sun.misc.IOUtils;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

/**
 * Created by upload on 2021/11/11.
 */
public  class TestJava {


    public static void main(String[] args) throws Exception {


        //Class<?> run = ClassLoader.getSystemClassLoader().loadClass("java.lang.Runtime");//CLASS对象
        //Class<?> run = Class.forName("com.upload.scy.A");
         Class<A> run = A.class;
        System.out.println(run);
//        // 还有 一种通过对象获取Class对象 a = new A(); a.getClass();
//        Constructor<?> c = run.getDeclaredConstructor();//获取Runtime类构造方法
//
//        c.setAccessible(true);//可以获取私有构造方法
//
//
//        Object o = c.newInstance();//new一个对象
//
//        Method method = run.getMethod("exec", String.class);//获取Runtime类的exec方法
//
//        method.invoke(o,"calc");// invoke调用



        Class<? extends Class> s = String.class.getClass();
        System.out.println(s);
//        s.forName("java.l"+"ang.Ru"+"ntime").getMethod("exec",String.class).invoke();

        String.class.getClass().forName("java.l"+"ang.Ru"+"ntime").getMethod("exec",String.class).invoke(String.class.getClass().forName("java.l"+"ang.Ru"+"ntime").getMethod("getRu"+"ntime").invoke(String.class.getClass()),"calc");

    }


}



class A{
    public A() {
        System.out.println("aaaaaaaa");
    }
}