/**
  * @FileName: Singleton1.java
  * @Author 
  * @Description:
  * @Date 2016年2月21日 下午6:35:03
  * @CopyRight CNP Corporation
  */
package com.jy.singleton;

/**
 * @author JY
 * @date:2016年2月21日下午6:35:03
 * 
 */

	//懒汉式单例类.在第一次调用的时候实例化 
public class Singleton1 {
	//私有的默认构造子
	private Singleton1(){}
	//注意，这里没有final 
	private static Singleton1 singleton=null;
	//静态工厂方法 
	private synchronized static Singleton1 getSingleton(){
		if(null==singleton){
			singleton=new Singleton1();
		}
		return singleton;
	}
}

