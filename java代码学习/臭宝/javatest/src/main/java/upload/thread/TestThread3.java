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
