package com.jucstudy.ThreadTest;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/6/8 13:41
 */
public class TestPath {

    public static void main(String[] args) {
        File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();

        String desktopPath = desktopDir.getAbsolutePath();

        System.out.println("------------------->>>---"+desktopPath);
    }
}
