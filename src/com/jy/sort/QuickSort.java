/**
  * @FileName: QuickSort.java
  * @Author 
  * @Description:
  * @Date 2016年2月21日 下午4:26:53
  * @CopyRight CNP Corporation
  */
package com.jy.sort;

import java.util.Arrays;

/**
 * @author JY
 * @date:2016年2月21日下午4:26:53
 * 
 */
//快速排序
//选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
//一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
public class QuickSort {

	/**   
	 * @Title: main   
	 * @Description:TODO  
	 * @param args void
	 */
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[]{2,4,9,3,6,7,1,5};
		QuickSort quickSort=new QuickSort();
		System.out.println("初始顺序："+Arrays.toString(a));
		quickSort.quickSort(a, 0, a.length-1);
		System.out.println("排序结果："+Arrays.toString(a));
	}
	
	public void quickSort(int[] a ,int left ,int right){
		//判断递归界限
		if(left<right){
			//基准值
			int key=a[left];
			int low=left;
			int high=right;
			while(low<high){
				while(low < high && a[high] > key){
					high--;
				}
				a[low]=a[high];
				while(low < high && a[low] < key){
					low++;
				}
				a[high]=a[low];
			}
//			System.out.println(Arrays.toString(a));
			a[low]=key;
			quickSort(a,left,low-1);
			quickSort(a,low+1,right);
		}
	}

}

