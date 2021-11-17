package upload.rererere;

/**
 * Created by upload on 2021/10/31.
 */

//什么是反射
public class tets02 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {

        Class c1 = Class.forName("upload.rererere.User");
        System.out.println(c1);
    }
}

class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

