package upload.ser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by upload on 2021/11/1.
 */
public class SerializationDemo implements Serializable {
    private String stringField;
    private int intField;

    public SerializationDemo(String s, int i) {
        this.stringField = s;
        this.intField = i;
    }

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(new SerializationDemo("gyyyy", 97777));
    }
}