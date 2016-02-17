/**
  * @FileName: Test.java
  * @Author 
  * @Description:
  * @Date 2016年2月17日 下午3:57:23
  * @CopyRight CNP Corporation
  */
package Try_Catch_Finally;

public class Test{
    
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Test().test());;
     }
  
     static int test()
     {
        int x = 1;
        try
        {
            
            //x++;
            //将结果存放起来，执行finally并不影响返回的x值
            return x;
        }
        finally
        {
            ++x;
        }
     }

}
