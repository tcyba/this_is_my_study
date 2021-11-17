import java.io.File;

/**
 * Created by upload on 2021/11/17.
 */


public class Eval {

    public static void main(String[] args) {
        String srcStr = "./";
        File srcFolder = new File(srcStr);
        File[] files = srcFolder.listFiles();
        System.out.println("ad");
        System.out.println(files);
        int i = 0;
        if (null != files) {
            File[] var5 = files;
            int var6 = files.length;

            for (int var7 = 0; var7 < var6; ++var7) {
                File file = var5[var7];
                String filename = file.getName();
                System.out.println(filename);
            }
        }
    }



}
