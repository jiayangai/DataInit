/**
 * @FileName: Test1.java
 * @Author
 * @Description:
 * @Date 2016年2月17日 下午4:05:45
 * @CopyRight CNP Corporation
 */
package Try_Catch_Finally;

public class Test1{

    /**
     * @paramargs add by zxx ,Dec 9, 2008
     */
    public static void main(String[] args){
        // TODO Auto-generated method stub
        System.out.println(new Test1().test());;
    }

    int test(){
        try{
            // Return并不是让函数马上返回，而是return语句执行后，将把返回结果放置进函数栈中，
            // 此时函数并不是马上返回，它要执行finally语句后才真正开始返回。
            return func1();
        }
        finally{
            return func2();
        }
    }

    // return语句先执行，finally语句后执行
    int func1(){
        System.out.println("func1");
        return 1;
    }

    int func2(){
        System.out.println("func2");
        return 2;
    }

}
