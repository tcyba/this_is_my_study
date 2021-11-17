package com.upload.scy;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashSet;

/**
 * Created by upload on 2021/11/11.
 */
public class Person {

    protected String name;

    private int age ;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
//        System.out.println("我爱邵彩银");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public int compareTo(Person o) {
        int num = this.name.compareTo(o.getName());
        if(num != 0){
            //先用name排序
            return num;
        }else{
            //如果姓名排序一样则以age进行排序
            return this.age - o.getAge();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public String toString() {
        return  "Person [name=" + name + ", age=" + age + "]1111";
    }


}
