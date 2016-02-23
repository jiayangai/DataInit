/**
 * @FileName: ChineseCoding.java
 * @Author
 * @Description:
 * @Date 2016年2月23日 上午10:48:00
 * @CopyRight CNP Corporation
 */
package InterviewProgram;

import java.util.Arrays;


public class ChineseCoding{

    /**
     * @Title: main
     * @Description:中文字符多种编码及各种编码的特征
     * @param args
     *            void
     * @throws Exception 
     */

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        String str = "我ab是中国人cd";
        int num = trimGBK(str.getBytes("UNICODE"), 5);
        System.out.println(str.substring(0, num));
    }

    private static int trimGBK(byte[] bytes, int n){
        int num = 0;
        boolean bChineseFirstHalf = false;
        System.out.println(Arrays.toString(bytes));
        for(int i = 0; i < n; i++){
            //gbk 中文字占2字节，判断中文字符位置
            if(bytes[i] < 0 && !bChineseFirstHalf){
                bChineseFirstHalf = true;
            } else{
                num++;
                bChineseFirstHalf = false;
            }
        }
        return num;

    }
}
