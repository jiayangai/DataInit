/**
 * @FileName: ShorUUID.java
 * @Author
 * @Description:
 * @Date 2016年3月16日 上午10:30:04
 * @CopyRight CNP Corporation
 */
package com.jy.shortUUID;

import java.util.UUID;

public class ShortUUID{

    /**
     * @Title: main
     * @Description:TODO
     * @param args
     *            void
     */

    public static void main(String[] args){
        // TODO Auto-generated method stub
        generateShortUuid();
    }

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z" };

    /**
     * @Title: generateShortUuid
     * @Description: 生成唯一的字符串16位
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static void generateShortUuid(){
        StringBuffer shortBuffer = new StringBuffer();
        StringBuffer shortBuffer1 = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for(int i = 0; i < 16; i++){
            //基数为2   长度为16
            //基数为4   长度为8
            String str = uuid.substring(i * 2, i * 2 + 2);
            int x = Integer.parseInt(str, 16);
//            int y=Integer.p
            shortBuffer.append(chars[x % 0x3E]);
        }
        System.out.println(shortBuffer.toString());
//        return shortBuffer.toString();
        for(int i = 0; i < 16; i++){
            String str = uuid.substring(i * 2, i * 2 + 2);
            int x = Integer.parseInt(str, 16);
            shortBuffer1.append(chars[x % 62]);
        }
        System.out.println(shortBuffer1.toString());
    }
}
