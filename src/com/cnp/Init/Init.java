package com.cnp.Init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Init{
    /**
     * @param args
     */
    // 驱动程序就是之前在classpath中配置的JDBC的驱动程序的JAR 包中
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    // 连接地址是由各个数据库生产商单独提供的，所以需要单独记住
    public static final String DBURL    = "jdbc:mysql://localhost:3306/andromeda_test";
    // 连接数据库的用户名
    public static final String DBUSER   = "root";
    // 连接数据库的密码
    public static final String DBPASS   = "123456";

    public void sqlExcute(String sql) throws Exception{
        Connection con = null;
        try{
            con = null;
            Statement stmt = null;
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS); // 2、连接数据库
            stmt = con.createStatement(); // 3、Statement 接口需要通过Connection
                                          // 接口进行实例化操作
            stmt.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            con.close(); // 4、关闭数据库
        }
    }

    // 用户 和用户头像
    public void userSqlAppend() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int x = 1; x <= 10000; x += 1000){
            StringBuilder sbUser = new StringBuilder();
            StringBuilder sbUserPic = new StringBuilder();
            sbUserPic.append("INSERT INTO t_userheadpicture (`id`, `picUrl`, `minPicUrl`) values");
            sbUser.append("INSERT INTO t_user (`userId`, `userName`, `password`, `qq`, `telephone`, `email`, `registerDate`, `gender`, `headPicId`, `nickName`, `registerType`, `signature`, `job`, `birthday`, `education`, `location`, `thirdPartyUid`) values");
            for(int i = x; i < x + 1000; i++){
                sbUserPic.append("(" + i + ", '" + i + ".jpg', '" + i + ".jpg'),");
                sbUser.append("(" + i + ", " + i + ", 'E10ADC3949BA59ABBE56E057F20F883E', NULL, null, NULL, '"
                        + sdf.format(new Date()) + "', 0, " + i + ", " + i + ",0, NULL, NULL, NULL, NULL, NULL,null),");
            }
            sqlExcute(sbUserPic.toString().substring(0, sbUserPic.toString().length() - 1));
            sqlExcute(sbUser.toString().substring(0, sbUser.toString().length() - 1));
        }
    }

    // 话题和话题图片
    public void userSqlAppend1() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int j = 1;
        for(int x = 1; x <= 10000; x += 500){
            StringBuilder sbTopic = new StringBuilder();
            StringBuilder sbTopicPic = new StringBuilder();
            sbTopic.append("INSERT INTO t_topic (`topicId`, `content`, `createDate`, `authorId`, `isRemoveId`,`anonymous`, `opTopicId`) values");
            sbTopicPic
                    .append("INSERT INTO t_topicpicture (`picUrl`, `middlePicUrl`, `minPicUrl`, `topicId`, `isRemove`) values");
            for(int i = x; i < x + 500; i++){
                for(; j <= i * 10; j++){
                    sbTopic.append("(" + j + ", '内容" + i + "__" + j + "','" + sdf.format(new Date()) + "'," + i
                            + ",0,0,null),");
                    for(int k = 1; k < 3; k++){
                        sbTopicPic.append("('xx,jpg','xxx.jpg','xxxx.jpg'," + j + ",0),");
                    }
                }
            }
            sqlExcute(sbTopic.toString().substring(0, sbTopic.toString().length() - 1));
            sqlExcute(sbTopicPic.toString().substring(0, sbTopicPic.toString().length() - 1));
        }
    }

    // 点赞和收藏
    public void userSqlAppend2() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Random rand = new Random();
        int j = 1;
        for(int x = 1; x <= 10000; x += 1000){
            StringBuilder sbLike = new StringBuilder();
            StringBuilder sbCollection = new StringBuilder();
            sbLike.append("INSERT INTO t_like (`likeId`, `topicId`, `userId`, `createDate`, `status`) values");
            sbCollection.append("INSERT INTO t_collection (`collectId`, `topicId`, `userId`) values");
            for(int i = x; i < x + 1000; i++){
                for(; j <= i * 10; j++){
                    sbLike.append("(" + j + ", " + (rand.nextInt(100000) + 1) + "," + i + ",'" + sdf.format(new Date())
                            + "',0),");
                    sbCollection.append("(" + j + "," + (rand.nextInt(100000) + 1) + "," + i + "),");
                }
            }
            sqlExcute(sbLike.toString().substring(0, sbLike.toString().length() - 1));
            sqlExcute(sbCollection.toString().substring(0, sbCollection.toString().length() - 1));
        }
    }

    // 评论
    public void userSqlAppend3() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int j = 1;
        for(int x = 1; x <= 5000; x += 500){
            StringBuilder sbComment = new StringBuilder();
            sbComment
                    .append("INSERT INTO t_comment (`commentId`, `content`, `createDate`, `authorId`, `topicId`,`isRemoved`, `parentId`, `replyTo`, `status`) values");

            for(int i = x; i < x + 500; i++){
                for(; j <= i * 10; j++){
                    sbComment.append("(" + j + ", '评论__" + j + "','" + sdf.format(new Date()) + "'," + i + "," + j
                            + ",0,null,null,1),");
                }
            }
            sqlExcute(sbComment.toString().substring(0, sbComment.toString().length() - 1));
        }
        for(int k = 1; k <= 20; k++){
            StringBuilder sbComment = new StringBuilder();
            sbComment
                    .append("INSERT INTO t_comment (`commentId`, `content`, `createDate`, `authorId`, `topicId`,`isRemoved`, `parentId`, `replyTo`, `status`) values");
            for(int i = 0; i < 2500; i++,j++){
                
                    sbComment.append("(" + j + ", '评论__" + j + "','" + sdf.format(new Date()) + "'," + k + "," + k*10
                            + ",0,"+k*10+",null,1),");
            }
            sqlExcute(sbComment.toString().substring(0, sbComment.toString().length() - 1));
        }
    }

    public static void main(String[] args){
        try{
            long startTime = System.currentTimeMillis(); // 获取开始时间
            new Init().userSqlAppend();
            long endTime = System.currentTimeMillis(); // 获取结束时间
            System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
