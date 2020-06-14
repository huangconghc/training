package com.file.demo;

import java.io.*;

public class FileDemo2 {
    public static void main(String[] args) throws IOException {


        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("E:\\java\\day2\\金毛狮王.txt"));

        for(int i=1;i<150000;i++){
            String outString = "金毛狮王"+i+"\r\n";
            bufferedOutputStream.write(outString.getBytes());
        }

        bufferedOutputStream.flush();
        bufferedOutputStream.close();



        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\java\\day2\\金毛狮王.txt")));
        for(String line = bufferedReader.readLine();line != null; line=bufferedReader.readLine()){
            System.out.println(line);
        }


    }

}
