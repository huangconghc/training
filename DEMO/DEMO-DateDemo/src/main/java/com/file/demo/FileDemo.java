package com.file.demo;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("D:\\IDEAworkspace\\DEMO");

        FileUtil.writerFile(file);

    }

}

