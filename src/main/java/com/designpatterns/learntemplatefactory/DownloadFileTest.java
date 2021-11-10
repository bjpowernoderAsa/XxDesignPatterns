package com.designpatterns.learntemplatefactory;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/20 16:02
 */
public class DownloadFileTest {


    public static void getImg(String url) throws IOException{
        long startTime = System.currentTimeMillis();
        URL imgURL = new URL(url.trim());//转换URL
        HttpURLConnection urlConn = (HttpURLConnection) imgURL.openConnection();//构造连接
        urlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.79 Safari/537.36");
        urlConn.connect();
        System.out.println(DownloadFileTest.class.toString()+":获取连接="+urlConn.getResponseMessage());
        if(urlConn.getResponseCode()==200){//返回的状态码是200 表示成功
            InputStream ins = urlConn.getInputStream(); //获取输入流,从网站读取数据到 内存中
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("tomcat6-stdout.2020-06-13.log")));
            int len=0;
            byte[] buff = new byte[1024*10];//10k缓冲流 视你内存大小而定咯

            while(-1!=(len=(new BufferedInputStream(ins)).read(buff))){//长度保存到len,内容放入到 buff
                out.write(buff, 0, len);//将图片数组内容写入到图片文件
            }
            urlConn.disconnect();
            ins.close();
            out.close();
            System.out.println(DownloadFileTest.class.toString()+"：获取图片完成,耗时="+((System.currentTimeMillis()-startTime)/1000)+"s");
        }
    }


    public static void main(String[] args) throws IOException{
//        DownloadFileTest.getImg("https://shanghairesback.oss-cn-shanghai.aliyuncs.com/studentInformationFile/FB9D8B41BA1B4630F730A77487C98F09.xlsx");

        DownloadFileTest.downLoadFromUrl("https://shanghairesback.oss-cn-shanghai.aliyuncs.com/studentInformationFile/FB9D8B41BA1B4630F730A77487C98F09.xlsx",
                "100校区导入模板.xlsx","d:/Xuuuuuu");

    }


    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒 
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误 
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流 
        InputStream inputStream = conn.getInputStream();
        //获取自己数组 
        byte[] getData = readInputStream(inputStream);

        //文件保存位置 
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }

        System.out.println("info:"+url+" download success");
    }

    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }


}
