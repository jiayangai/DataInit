/**
  * @FileName: MapSort.java
  * @Author 
  * @Description:
  * @Date 2016年2月23日 上午9:40:11
  * @CopyRight CNP Corporation
  */
package com.jy.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapSort{

    /**   
     * @Title: main   
     * @Description:map排序
     * @param args void
     */

    public static void main(String[] args){
        // TODO Auto-generated method stub
        Map<String, Integer> map=new HashMap<String , Integer>();
        map.put("张三", 1);
        map.put("何五", 3);
        map.put("王二", 2);
        map.put("李四", 1);
        ////这里将map.entrySet()转换成list
        List<Map.Entry<String, Integer>> list=new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            //升序排序
            public int compare(Entry<String, Integer> m1 ,Entry<String,Integer> m2){
                return m1.getValue().compareTo(m2.getValue());
            }
        });
        
        for(Entry<String, Integer> entry : list){
            System.out.println(entry.getKey()+":"+entry.getValue()); 
        }
    }

}
