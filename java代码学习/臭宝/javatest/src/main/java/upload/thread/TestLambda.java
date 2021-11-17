package upload.thread;

/**
 * Created by upload on 2021/11/4.
 */
public class TestLambda {


    public static void main(String[] args) {
        ILike i = new Like();
        i.lambda();
        System.out.println();
    }
}

interface ILike{
    void lambda();
}

class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}