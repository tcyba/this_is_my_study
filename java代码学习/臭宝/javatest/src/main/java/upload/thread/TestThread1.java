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
