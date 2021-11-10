package com.designpatterns.ThreadTest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/6/8 13:52
 */
public class stream {

    public static void main(String[] args) {
        try {
            String url = "https://shanghairesback.oss-cn-shanghai.aliyuncs.com/studentInformationFile/62622D216F663D710BFAEA13A0AB9E0A.xls";
            String fileName = "hhhh.xlsx";
            String savePath = "c:/file/";
            long startTime=System.currentTimeMillis();   //获取开始时间

//            downLoadFromUrl(url,fileName,savePath);
            downloadThings(url,fileName,savePath);

            long endTime=System.currentTimeMillis(); //获取结束时间

            System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        }catch (Exception e){

        }
    }

    public static void downloadThings(String urls,String fileName,String path) throws IOException{
        String name=urls.substring(urls.trim().lastIndexOf("/"));

        URL url=new URL(urls);
        InputStream in= url.openConnection().getInputStream();

        File file=new File(path+fileName);

        FileOutputStream out=new FileOutputStream(file,true);

//计数器
//开始读
        int ch;
        byte[] buffer=new byte[1024];
        while((ch=in.read(buffer))!=-1){
            out.write(buffer,0,ch);
        }
        out.flush();
        in.close();
        out.close();
    }

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
