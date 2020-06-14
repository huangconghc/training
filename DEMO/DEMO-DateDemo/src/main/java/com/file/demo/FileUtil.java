package com.file.demo;


/*
获取功能：
 *		public String getAbsolutePath():获取绝对路径
 *		public String getPath()：获取绝对路径
 *		public String getName()：获取名字
 *		public String length()：获取长度，字节数
 *		public String lastModified()：获取最后一次的修改时间，毫秒值
 *		public String[] list():获取指定目录下的所有文件或文件夹的名称
 *		public File[] listFile():获取目录下所有文件或文件夹的File数组
 */
import java.io.File;

public class FileUtil {
    public static void writerFile(File srcFolder) {

        File[] fileList = srcFolder.listFiles();

        for (File files : fileList) {
            if (files.isDirectory()) {
                writerFile(files);
            } else {
                System.out.println(files);
            }
        }
    }
}
