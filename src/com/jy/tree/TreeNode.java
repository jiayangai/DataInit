/**
  * @FileName: TreeNode.java
  * @Author 
  * @Description:
  * @Date 2016年2月22日 下午3:09:41
  * @CopyRight CNP Corporation
  */
package com.jy.tree;

//二叉树的节点数据结构 
public class TreeNode{
    int key=0;
    String data=null;
    boolean isVisited=false;
    TreeNode leftChild=null;
    TreeNode rightChild=null;
    
    public TreeNode(){};
    
    public TreeNode (int key,String data){
        this.key=key;
        this.data=data;
        this.leftChild=leftChild;
        this.rightChild=rightChild;
    }
}
