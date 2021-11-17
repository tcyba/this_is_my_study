package upload.rererere;

import java.lang.reflect.Method;

/**
 * Created by upload on 2021/11/1.
 */
public class InvokeTest {
    public void test(String[] arg) {
        for (String string : arg) {
            System.out.println("zp is " + string);
        }
    }
    public InvokeTest() {
    }
    public static void main(String[] args) throws Exception {
        //获取字节码对象,这里要填好你对应对象的包的路径
        Class<InvokeTest> clazz = (Class<InvokeTest>) Class.forName("upload.rererere.InvokeTest");
        //形式一：获取一个对象
//        Constructor con =  clazz.getConstructor();
//        InvokeTest m = (InvokeTest) con.newInstance();
        //形式二：直接new对象，实际上不是框架的话，自己写代码直接指定某个对象创建并调用也可以
        InvokeTest m = new InvokeTest();
        String[] s = new String[]{"handsome", "smart"};
        //获取Method对象
        Method method = clazz.getMethod("test", String[].class);
        //调用invoke方法来调用
        method.invoke(m, (Object) s);
        clazz.newInstance();
    }
}