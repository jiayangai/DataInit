/**
 * @FileName: BinaryTree.java
 * @Author
 * @Description:
 * @Date 2016年2月22日 下午3:07:11
 * @CopyRight CNP Corporation
 */
package com.jy.tree;

import java.util.Stack;

public class BinaryTree{

    /**
     * @Title: main
     * @Description:二叉树的链式存储
     * @param args
     *            void
     */
    private TreeNode root = null;

    public BinaryTree(){
        root = new TreeNode(1, "rootNode(A)");
    }

    /**
     * 创建一棵二叉树
     * 
     * <pre>
     *           A 
     *     B          C 
     *  D     E            F
     * </pre>
     */
    public void createBinaryTree(TreeNode root){
        TreeNode newNodeB = new TreeNode(2, "B");
        TreeNode newNodeC = new TreeNode(2, "C");
        TreeNode newNodeD = new TreeNode(2, "D");
        TreeNode newNodeE = new TreeNode(2, "E");
        TreeNode newNodeF = new TreeNode(2, "F");
        root.leftChild = newNodeB;
        root.rightChild = newNodeC;
        root.leftChild.leftChild = newNodeD;
        root.leftChild.rightChild = newNodeE;
        root.rightChild.rightChild = newNodeF;
    }

    public boolean isEmpty(){
        return root == null;
    }

    // 树的高度
    public int height(TreeNode subTree){
        if(subTree == null){
            return 0; // 递归结束，空树高度为0
        } else{
            int i = height(subTree.leftChild);
            int j = height(subTree.rightChild);
            return (i < j) ? (j + 1) : (i + 1);
        }
    }

    // 节点个数

    public int size(TreeNode subTree){
        if(null == subTree){
            return 0;
        } else{
            return 1 + size(subTree.leftChild) + size(subTree.rightChild);
        }
    }

    // 返回双亲节点(wuyong)
    public TreeNode parent(TreeNode element){
        return (root == null || root == element) ? null : parent(root);
    }

    public TreeNode parent(TreeNode subTree, TreeNode element){
        if(subTree == null)
            return null;
        if(subTree.leftChild == element || subTree.rightChild == element)
            // 返回父节点
            return subTree;
        TreeNode p;
        // 先在坐子树中找，如果没有，去右子树
        if((p = parent(subTree.leftChild, element)) != null)
            // 递归在左子数种搜索
            return p;
        else{
            // 递归在右子数种搜索
            return parent(subTree.rightChild, element);
        }
    }

    public TreeNode getLeftChildNode(TreeNode element){
        return (element != null) ? element.leftChild : null;
    }

    public TreeNode getRightChildNode(TreeNode element){
        return (element != null) ? element.rightChild : null;
    }

    public TreeNode getRoot(){
        return root;
    }

    // 在释放某个结点时，该结点的左右子树都已经释放，
    // 所以应该采用后续遍历，当访问某个结点时将该结点的存储空间释放
    public void destroy(TreeNode subTree){
        // 删除根为subTree的子树
        if(subTree != null){
            // 删除左子树
            destroy(subTree.leftChild);
            // 删除右子树
            destroy(subTree.rightChild);
            // 删除根节点
            subTree = null;
        }
    }

    public void traverse(TreeNode subTree){
        System.out.println("key:" + subTree.key + "--name:" + subTree.data);
        traverse(subTree.leftChild);
        traverse(subTree.rightChild);
    }

    public void visited(TreeNode subTree){
        subTree.isVisited = true;
        System.out.println("key:" + subTree.key + "--name:" + subTree.data);
    }

    // 前序遍历
    public void preOrder(TreeNode subTree){
        if(subTree != null){
            visited(subTree);
            preOrder(subTree.leftChild);
            preOrder(subTree.rightChild);
        }
    }

    // 中序遍历
    public void inOrder(TreeNode subTree){
        if(subTree != null){
            inOrder(subTree.leftChild);
            visited(subTree);
            inOrder(subTree.rightChild);
        }
    }

    // 后序遍历
    public void postOrder(TreeNode subTree){
        if(subTree != null){
            postOrder(subTree.leftChild);
            postOrder(subTree.rightChild);
            visited(subTree);
        }
    }

    // 前序遍历的非递归实现
    public void nonRecPreOrder(TreeNode p){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = p;
        while(node != null || stack.size() > 0){
            while(node != null){
                visited(node);
                stack.push(node);
                node = node.leftChild;
            }
            while(stack.size() > 0){
                node = stack.pop();
                node = node.rightChild;
                if(node != null){
                    visited(node);
                    stack.push(node);
                    node = node.leftChild;
                }
            }
        }
    }

    // 中序遍历的非递归实现
    public void nonRecInOrder(TreeNode p){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = p;
        while(node != null || stack.size() > 0){
            // 存在左子树
            while(node != null){
                stack.push(node);
                node = node.leftChild;
            }
            // 栈非空
            if(stack.size() > 0){
                node = stack.pop();
                visited(node);
                node = node.rightChild;
            }
        }
    }

    // 后序遍历的非递归实现
    public void noRecPostOrder(TreeNode p){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = p;
        while(p != null){
            // 左子树入栈
            for(; p.leftChild != null; p = p.leftChild){
                stack.push(p);
            }
            // 当前结点无右子树或右子树已经输出
            while(p != null && (p.rightChild == null || p.rightChild == node)){
                visited(p);
                // 纪录上一个已输出结点
                node = p;
                if(stack.empty())
                    return;
                p = stack.pop();
            }
            // 处理右子树
            stack.push(p);
            p = p.rightChild;
        }
    }

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree(bt.root);
        System.out.println("the size of the tree is " + bt.size(bt.root));
        System.out.println("the height of the tree is " + bt.height(bt.root));
        System.out.println("*******(前序遍历)[ABDECF]遍历*****************");
        bt.preOrder(bt.root);

        System.out.println("*******(中序遍历)[DBEACF]遍历*****************");
        bt.inOrder(bt.root);

        System.out.println("*******(后序遍历)[DEBFCA]遍历*****************");
        bt.postOrder(bt.root);
        
        System.out.println("***非递归实现****(前序遍历)[ABDECF]遍历*****************");  
        bt.nonRecPreOrder(bt.root);  
          
        System.out.println("***非递归实现****(中序遍历)[DBEACF]遍历*****************");  
        bt.nonRecInOrder(bt.root);  
          
        System.out.println("***非递归实现****(后序遍历)[DEBFCA]遍历*****************");  
        bt.noRecPostOrder(bt.root); 
    }

}
