/**
  * @FileName: Singleton.java
  * @Author 
  * @Description:
  * @Date 2016年2月21日 下午6:28:33
  * @CopyRight CNP Corporation
  */
package com.jy.singleton;

/**
 * @author JY
 * @date:2016年2月21日下午6:28:33
 * 
 */
	//饿汉单例.在类初始化时，已经自行实例化 
public class Singleton {
	//私有的默认构造子
	private Singleton(){}
	//已经自行实例化 
	private static final Singleton singleton=new Singleton();
	//静态工厂方法 
	private static Singleton getSingleton(){
		return singleton;
	}
}

