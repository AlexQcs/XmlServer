import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by alex on 2017/6/30.
 */
public class StreamTool {
    public static byte[] read(InputStream inputStream) throws IOException {
        ByteArrayOutputStream os=new ByteArrayOutputStream();
        byte[] bt=new byte[1024];
        int len=0;
        while ((len=inputStream.read(bt))!=-1){
            os.write(bt,0,len);
        }
        inputStream.close();
        return os.toByteArray();
    }
}
