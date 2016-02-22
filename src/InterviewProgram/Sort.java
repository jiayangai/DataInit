/**
 * @FileName: Sort.java
 * @Author jy
 * @Description:
 * @Date 2016年2月19日 上午11:13:42
 * @CopyRight CNP Corporation
 */
package InterviewProgram;

import java.util.Arrays;


public class Sort{

    //mian
    public static void main(String[] s){
        Sort sort=new Sort();
//        sort.sort1();
//        sort.sort2();
        sort.sort3();
    }
    
    //选择排序
    //选择出最小（大）的值，与之交换位置
    public void sort1(){
        int[] a=new int[]{38, 17, 16, 16, 7, 31, 39, 32, 2, 11};
        for(int i=0;i<a.length;i++){
            // for(int j = i+1; j < a.length; j++)
            for(int j = i+1; j < a.length; j++){
                int tmp=a[i];
                if(a[i]>a[j]){
                    a[i]=a[j];
                    a[j]=tmp;
                }
            }
        System.out.println(Arrays.toString(a));
        }
//        System.out.println(Arrays.toString(a));
    }
/*          [2, 38, 17, 16, 16, 31, 39, 32, 7, 11]
            [2, 7, 38, 17, 16, 31, 39, 32, 16, 11]
            [2, 7, 11, 38, 17, 31, 39, 32, 16, 16]
            [2, 7, 11, 16, 38, 31, 39, 32, 17, 16]
            [2, 7, 11, 16, 16, 38, 39, 32, 31, 17]
            [2, 7, 11, 16, 16, 17, 39, 38, 32, 31]
            [2, 7, 11, 16, 16, 17, 31, 39, 38, 32]
            [2, 7, 11, 16, 16, 17, 31, 32, 39, 38]
            [2, 7, 11, 16, 16, 17, 31, 32, 38, 39]
            [2, 7, 11, 16, 16, 17, 31, 32, 38, 39]*/
    
    
    //插入排序
    //从第2个数开始，将比第1个数小（大）的数字，插到前面序列中
    public void sort2(){
        int[] a=new int[]{38, 17, 16, 16, 7, 31, 39, 32, 2, 11};
        for(int i=1;i<a.length;i++){
            //for(int j=0;j<i;j++)
            for(int j=0;j<i;j++){
                int tmp=a[j];
                if(a[j]>a[i]){
                    a[j]=a[i];
                    a[i]=tmp;
                }
            }
            System.out.println(Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));
    }
/*          [17, 38, 16, 16, 7, 31, 39, 32, 2, 11]
            [16, 17, 38, 16, 7, 31, 39, 32, 2, 11]
            [16, 16, 17, 38, 7, 31, 39, 32, 2, 11]
            [7, 16, 16, 17, 38, 31, 39, 32, 2, 11]
            [7, 16, 16, 17, 31, 38, 39, 32, 2, 11]
            [7, 16, 16, 17, 31, 38, 39, 32, 2, 11]
            [7, 16, 16, 17, 31, 32, 38, 39, 2, 11]
            [2, 7, 16, 16, 17, 31, 32, 38, 39, 11]
            [2, 7, 11, 16, 16, 17, 31, 32, 38, 39]
            [2, 7, 11, 16, 16, 17, 31, 32, 38, 39]*/
    
    
    //冒泡排序
    //依次比较相邻2个数，取出最大（小）的数。最后最大（小）的数右靠
    public void sort3(){
        int[] a=new int[]{38, 17, 16, 16, 7, 31, 39, 32, 2, 11};
        for(int i=0;i<a.length;i++){
            // for(int j=0;j<a.length-1-i;j++)
            for(int j=0;j<a.length-1-i;j++){
                int tmp=a[j];
                if(a[j]>a[j+1]){
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
            System.out.println(Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));
    }
    
/*          [17, 16, 16, 7, 31, 38, 32, 2, 11, 39]
            [16, 16, 7, 17, 31, 32, 2, 11, 38, 39]
            [16, 7, 16, 17, 31, 2, 11, 32, 38, 39]
            [7, 16, 16, 17, 2, 11, 31, 32, 38, 39]
            [7, 16, 16, 2, 11, 17, 31, 32, 38, 39]
            [7, 16, 2, 11, 16, 17, 31, 32, 38, 39]
            [7, 2, 11, 16, 16, 17, 31, 32, 38, 39]
            [2, 7, 11, 16, 16, 17, 31, 32, 38, 39]
            [2, 7, 11, 16, 16, 17, 31, 32, 38, 39]
            [2, 7, 11, 16, 16, 17, 31, 32, 38, 39]
            [2, 7, 11, 16, 16, 17, 31, 32, 38, 39]*/
    
}
