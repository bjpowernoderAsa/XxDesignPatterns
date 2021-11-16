package com.jucstudy.ThreadTest;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/6/8 10:18
 */
public class Test {

    public static void main(String[] args) throws Exception{
        String url = "https://shanghairesback.oss-cn-shanghai.aliyuncs.com/studentInformationFile/FB9D8B41BA1B4630F730A77487C98F09.xlsx";
        try {
            URL root = new URL(url);
            saveBinary(root);
        } catch (MalformedURLException e) {
            // TODO: handle exception
            System.out.println(url + "is not URL");
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }


    public static void saveBinary(URL u) throws IOException {
        // TODO Auto-generated method stub
        URLConnection uc = u.openConnection();
        String contentType = uc.getContentType();
        int contentLength = uc.getContentLength();
        /*
         * 可以限制不下载哪种文本文件
        if (contentType.startsWith("text/") || contentLength == -1) {
            throw new IOException("This is not a binary file.");
        }*/

        try (InputStream raw = uc.getInputStream()) {
            InputStream in = new BufferedInputStream(raw);
            byte[] data = new byte[contentLength];
            int offset = 0;
            while (offset < contentLength) {
                int bytesRead = in.read(data, offset, data.length - offset);
                if (bytesRead == -1) {
                    break;
                }
                offset += bytesRead;
            }

            if (offset != contentLength) {
                throw new IOException("Only read " + offset
                        + " bytes; Expected " + contentLength + " bytes");
            }

            //文件保存位置
            File saveDir = new File("f:/resource/");
            if(!saveDir.exists()){
                saveDir.mkdir();
            }
            File file = new File(saveDir+File.separator+"测试文件名.xlsx");
            String filename = "存储位置";
            try (FileOutputStream fout = new FileOutputStream(file)) {
                fout.write(data);
                fout.flush();
            }
        }
    }


}
