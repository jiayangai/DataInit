/**
  * @FileName: io_1.java
  * @Author 
  * @Description:
  * @Date 2016年2月21日 下午9:24:19
  * @CopyRight CNP Corporation
  */
package com.jy.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author JY
 * @date:2016年2月21日下午9:24:19
 * 
 */

public class IO_1 {

	/**   
	 * @Title: main   
	 * @Description:TODO  
	 * @param args void
	 * @throws Exception 
	 */

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		IO_1 io=new IO_1();
		char[] a=io.readFile("F:/python/a.txt");
		FileWriter fileWriter=new FileWriter("F:/python/c.txt");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			fileWriter.write(a[i]+"\n");
		}
		fileWriter.close();
//		System.out.println(io.getClass().getResource("/").getPath());
	}
	
	public char[] readFile(String fileName) throws Exception{
		String s=null;
		File file=new File(fileName);
		FileReader reader=new FileReader(file);
		char[] buf=new char[(int)file.length()];
		int len=reader.read(buf);
		s=new String(buf,0,len);
		char[] a=s.toCharArray();
		return a;
	}
}

