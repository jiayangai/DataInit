/**
  * @FileName: Num_Char_Other_Total.java
  * @Author 
  * @Description:
  * @Date 2016年2月22日 下午2:40:08
  * @CopyRight CNP Corporation
  */
package InterviewProgram;

public class Num_Char_Other_Total{

    /**   
     * @Title: main   
     * @Description:统计一窜字符中，数字，字符，其他符号的个数 
     * @param args void
     */

    public static void main(String[] args){
        // TODO Auto-generated method stub
        String s="abc中def51ghc国12i";
        int englishCount=0;
        int chineseCount=0;
        int numCount=0;
        for(int i = 0; i < s.length(); i++){
            char c=s.charAt(i);
            if('0'<=c && '9'>=c){
                numCount++;
            }else if('A'<=c && 'z'>=c){
                englishCount++;
            }else {
                chineseCount++;
            }
        }
        System.out.println("数字个数："+numCount+"\n"+"英文字符个数："+englishCount+"\n"+"汉子个数："+chineseCount);
    }

}
