package com.eheartcare.docdemo.docdemo;

import java.io.File;

/**
 * Created by Administrator on 2016/3/15 0015.
 */
public class rename{
    public static void main(String[] args) {
        File file = new File("D:\\test");
        listF(file);

    }
    public static void listF(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            if(files != null){
                for(int i=0;i<files.length;i++){
                    String name = files[i].getName();
                    String[] split = name.split("");
                    StringBuffer buffer = new StringBuffer();
                    for(int j = 0;j<split.length;j++){
                        if(!split[j].equals("-")){
                            if(!split[j].equals("@")){
                            buffer.append(split[j]);}
                        }
                    }
                    System.out.println(buffer);
                    files[i].renameTo(new File(buffer+""));

                    listF(files[i]);
                }
            }
        }
        if(file != null){
            System.out.println(file.getAbsolutePath());
        }
    }

}
