/**
  * @FileName: FolderCopy.java
  * @Author 
  * @Description:
  * @Date 2016年2月22日 上午11:09:17
  * @CopyRight CNP Corporation
  */
package com.jy.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

public class FolderCopy{

    /**   
     * @Title: main   
     * @Description:TODO  
     * @param args void
     * @throws Exception 
     */

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        //文件夹是否存在
        File folder=new File("F://python爬虫");
        if(!(folder.exists()) && folder.isDirectory())
            throw new Exception("目录不存在");
        //获取目录下所有文件并且过滤
        File[] files=folder.listFiles(new FilenameFilter(){
            
            @Override
            public boolean accept(File dir, String name){
                // TODO Auto-generated method stub
                return name.endsWith(".py");
            }
        });
        File copyFolder=new File("F://python");
        //文件夹不存在则创建
        if(!(copyFolder.exists()) && copyFolder.isDirectory())
            copyFolder.mkdir();
        for(File file : files){
            FileInputStream fis=new FileInputStream(file);
            //替换文件名字
            String newFileName =file.getName().replaceAll(".py", ".java");
            FileOutputStream fos=new FileOutputStream(new File(copyFolder,newFileName));
            //缓冲区读写
            int len=0;
            byte[] buf=new byte[1024];   
            while(-1!=(len=fis.read(buf))){
                fos.write(buf, 0, len);
            }
        }
    }

}
