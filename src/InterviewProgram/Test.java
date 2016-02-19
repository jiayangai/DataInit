/**
  * @FileName: Test.java
  * @Author 
  * @Description:
  * @Date 2016年2月19日 上午10:53:25
  * @CopyRight CNP Corporation
  */
package InterviewProgram;

import java.util.Arrays;

public class Test{

    /**   
     * @Title: main   
     * @Description:颠倒数组顺序
     * @param args void
     */

    public static void main(String[] args){
        // TODO Auto-generated method stub
        int i[]=new int[]{
                (int)(Math.random() *1000),
                (int)(Math.random() *1000),
                (int)(Math.random() *1000),
                (int)(Math.random() *1000),
                (int)(Math.random() *1000),
                (int)(Math.random() *1000),
                (int)(Math.random() *1000),
                (int)(Math.random() *1000)
        };
        System.out.println(i);
        System.out.println(Arrays.toString(i));
        swap(i);
        System.out.println(Arrays.toString(i));
    }
    public static void swap(int[] a){
        for(int i = 0; i < a.length/2; i++){
            int tmp=a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=tmp;
        }
    }
        
}
