/**
  * @FileName: Recursion.java
  * @Author 
  * @Description:
  * @Date 2016年2月21日 下午5:23:11
  * @CopyRight CNP Corporation
  */
package com.jy.recursion;

/**
 * @author JY
 * @date:2016年2月21日下午5:23:11
 * 
 */

public class Recursion {

	/**   
	 * @Title: main   
	 * @Description:递归 
	 * @param args void
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recursion recursion=new Recursion();
		System.out.println(recursion.age(8));
	}
	
	//第1个人10，第2个比第1个人大2岁，依次递推，请用递归方式计算出第8个人多大？
	public int age(int n){
		if(1==n)
			return 10;
		return age(n-1)+2;
	}

}

