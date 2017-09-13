import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by alex on 2017/9/13.
 */
public class downLoadFile extends HttpServlet {

    private final String programTxt = "C:\\Users\\alex\\Desktop\\nomalProgram.txt";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            downLoadProgramFile(programTxt, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void downLoadProgramFile(String path, HttpServletResponse response) throws Exception {
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            String name = URLEncoder.encode(file.getName(), "utf-8");
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            response.setHeader("Content-Disposition", "attachment; filename=" + name + "");
            //获取响应报文输出流对象
            ServletOutputStream out = response.getOutputStream();
            //输出
            out.write(bytes);
            out.flush();
            out.close();
        }
    }
}
