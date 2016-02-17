/**
 * @FileName: Son.java
 * @Author
 * @Description:
 * @Date 2016年2月17日 上午10:26:12
 * @CopyRight CNP Corporation
 */
package OO;

public class Son extends Father{
    public Object name = "儿子";

    @Override
    public void test(){

        System.out.println("子类的覆盖父类的方法");

    }

    public void say(){

        System.out.println("子类的普通方法");

    }

    public static void main(String[] args){

        // 编译时类型和运行时类型完全一样，因此不不存在多态

        Father p = new Father();

        System.out.println(p.name);

        p.base();

        p.test();
        System.out.println("-----------------------------");
        // 编译时类型和运行时类型完全一样，因此不不存在多态

        Son m = new Son();

        System.out.println(m.name);

        m.base();

        m.test();

        m.say();
        System.out.println("-----------------------------");
        // 下面编译时类型和运行时类型不一样，多态发生
        // 上溯造型
        Father pm = new Son();

        // 输出小武——这说明访问的是父类的变量

        System.out.println(pm.name);

        // 下面调用将执行从父类继承到的base方法

        pm.base();

        // 下面调用将执行子类的test方法

        pm.test();

        // 因为编译时类型是父类，父类没有提供say方法，所以下面代码编译时会出错

        // pm.say();

        System.out.println("-----------------------------");

        Son son = (Son)pm;
        son.say();
        
    }

}
