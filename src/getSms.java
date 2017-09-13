

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;


/**
 * Created by alex on 2017/6/28.
 */
public class getSms extends HttpServlet {

    private int mPostTimes = 0;

    public getSms() {
        super();
    }

    public void destory() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<command>" +
                "<tasklist>" +
                "<taskcount>1</taskcount>" +
                "<taskitem>" +
                "<tasktype>01</tasktype>" +
                "<taskid>402881d323c2d3010123cfecdd100008</taskid>" +
                "<contents>" +
                "<content>" +
                "<csize>38814</csize>" +
                "<link>/download/res.xml</link>" +
                "<md5> b39318390aba4592a3c09109d0775a92</md5>" +
                "<stardate>2010-06-20</stardate>" +
                "<enddate>2010-06-22</enddate>" +
                "<playmode>1</playmode>" +
                "</content>" +
                "</contents>" +
                "</taskitem>" +
                "</tasklist>" +
                "</command>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuffer buffer = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        byte[] data = StreamTool.read(req.getInputStream());
//        String xml = new String(data, "UTF-8");


        String taskType = req.getHeader("command");
        String mac = req.getHeader("mac");
//        String tasktype = req.getHeader("taskType");
        System.out.println("-----------------------进到getSms--------------------------");
        System.out.println("buffer：" + buffer.toString());
        System.out.println("mac:" + mac);
        System.out.println(new Date() + "tasktype:" + taskType);

        switch (taskType) {
            case "getTask":
                try {
                    returnProgramXml(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "program":
                try {
                    downLoadFile("", resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "taskreport":
                try {
                    reportResult(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println(buffer.toString());
                break;
        }
    }

    public void downLoadFile(String path, HttpServletResponse response) throws Exception {
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

    public void returnConfigXml(HttpServletRequest req, HttpServletResponse response) throws Exception {

        if (!(mPostTimes == 0)) return;
//        mPostTimes++;
        response.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<command>\n" +
                        "  <tasklist>\n" +
                        "    <taskcount>1</taskcount>\n" +
                        "    <taskitem>\n" +
                        "    <tasktype>config</tasktype>\n" +
                        "    <taskid>config</taskid>\n" +
                        "    <config>\n" +
                        "      <startuptime>08:00</startuptime>\n" +
                        "      <shutdowntime>18:30</shutdowntime>\n" +
                        "      <diskspacealarm>500</diskspacealarm>\n" +
                        "      <serverconfig>http://128.160.97.6:16300/zhyh/</serverconfig>\n" +
                        "      <selectinterval>60</selectinterval>\n" +
                        "      <volume>50</volume>\n" +
                        "      <ftpserver>ygqd/eWdxZA==@128.160.97.6:1282</ftpserver>\n" +
                        "      <httpserver>http://128.160.97.6:16300/zhyh/</httpserver>\n" +
                        "      <downloadrate>100</downloadrate>\n" +
                        "      <downloadtime>00:00:59-23:59:00</downloadtime>\n" +
                        "      <logserver>/logs/230000000</logserver>\n" +
                        "      <uploadlogtime>12:00</uploadlogtime>\n" +
                        "      <keeplogtime>3</keeplogtime>\n" +
                        "    </config>\n" +
                        "    </taskitem>\n" +
                        "  </tasklist>\n" +
                        "</command>");
    }

    public void reportResult(HttpServletRequest req, HttpServletResponse response) throws Exception {

        if (!(mPostTimes == 0)) return;
//        mPostTimes++;
        response.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<command>\n" +
                "<result>0</result>\n" +
                "</command>");
    }

    public void returnProgramXml(HttpServletRequest req, HttpServletResponse response) throws Exception {

        if (!(mPostTimes == 0)) return;
//        mPostTimes++;
        response.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<command>\n" +
                "  <tasklist>\n" +
                "    <taskcount>2</taskcount>\n" +
                "    <taskitem>\n" +
                "      <tasktype>downloadres</tasktype>\n" +
                "      <taskid>e8116e59-790d-4805-a5fc-42f49810f26b</taskid>\n" +
                "      <contents>\n" +
                "        <content>\n" +
                "          <csize>2542</csize>\n" +
                "          <link>workspace/tempfiles/00-16-E8-48-83-5A/resource.xml</link>\n" +
                "          <md5>fd487e05105347980f335d25015225b3</md5>\n" +
                "        </content>\n" +
                "      </contents>\n" +
                "    </taskitem>\n" +
                "     <taskitem>\n" +
                "      <tasktype>program</tasktype>\n" +
                "      <taskid>e148a627-8d74-4d69-a2d2-80c7ae5ec7c8</taskid>\n" +
                "      <contents>\n" +
                "        <content>\n" +
                "          <csize>2388</csize>\n" +
                "          <link>downloadfile</link>\n" +
                "          <md5>ab6554777b16f5a549fe66e4a4327f4b</md5>\n" +
                "          <playmode>1</playmode>\n" +
                "        </content>\n" +
                "      </contents>\n" +
                "    </taskitem>\n" +
                "  </tasklist>\n" +
                "</command>");
    }


}
