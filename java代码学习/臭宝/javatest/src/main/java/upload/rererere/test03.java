package upload.rererere;

/**
 * Created by upload on 2021/10/31.
 */

//测试cals类
public class test03 {

    public static void main(String[] args) throws ClassNotFoundException {

        Person person = new Student();
        System.out.println("z这个11"+person.name);

        // 1
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //2
        Class c2 =Class.forName("upload.rererere.Student");
        System.out.println(c2.hashCode());

        //3
        Class c3 = Student.class;
        System.out.println(c3);

        //4
        Class c4 = Integer.TYPE;

        System.out.println(c4.getSuperclass());
//        Class c5 = Float.TYPE;
//        System.out.println(c5);
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person{

    public String name;

}

class Student extends Person{

    public Student(){
        this.name = "XUEs";
    }
}

class Teacher extends Person{

    public Teacher(){
        this.name = "XUEs";
    }
}