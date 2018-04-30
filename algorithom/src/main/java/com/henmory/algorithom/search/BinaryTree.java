package com.henmory.algorithom.search;

/**
 * author: henmory
 * time:  3/13/18
 * function:
 * description: 二叉排序树要求链表是中序遍历
 */

public class BinaryTree {


    /**
     *  @author henmory
     *  @date 3/13/18
     *  @description    这是一个二叉链表结点
     *
     *  @param
     *
     *  @return
    */
    public class BinaryTreeNode{
        public int data;
        public BinaryTreeNode lChild;
        public BinaryTreeNode rChild;

        public BinaryTreeNode(int data, BinaryTreeNode lChild, BinaryTreeNode rChild) {
            this.data = data;
            this.lChild = lChild;
            this.rChild = rChild;
        }
    }

    /**
     *  @author henmory
     *  @date 3/13/18
     *  @description 二叉排序树的查找
     *
     *  @param  treeNode 要查看的结点
     *          key 要查找的值
     *          parentNode 要查看结点的父结点
     *          position 最后一次查找的结点
     *  @return
    */
    public int searchBinaryTreeNode(BinaryTreeNode treeNode, int key, BinaryTreeNode parentNode, BinaryTreeNode position){

        //查找某个结点时，该结点为空，表明它的父结点是叶子节点，也就说明没有找到我们的结点，赋值父结点
        if (null == treeNode){
            position = parentNode;
            return 0;
        }

        // 查找的值小于该结点的值，那么查找它的左子树
        if (treeNode.data > key){

            return searchBinaryTreeNode(treeNode.lChild, key, treeNode, position);
        }else if(treeNode.data < key){

            return searchBinaryTreeNode(treeNode.rChild, key, treeNode, position);
        //表明查找的treeNode的值是我们想要的，赋值给我们的当前结点
        }else{
            position = treeNode;
            return 1;
        }
    }

    /**
     *  @author henmory
     *  @date 3/13/18
     *  @description 插入某个结点到一颗二叉树
     *
     *  @param  treeNode    二叉树的跟节点
     *          key     要出入的结点的值
     *
     *  @return
    */
    public int  insertBinaryTreeNode(BinaryTreeNode treeNode, int key){

        BinaryTreeNode node = null;
        BinaryTreeNode insertNode = new BinaryTreeNode(0,null,null);

        //如果没有找到要插入的值
        if (1 != searchBinaryTreeNode(treeNode, key, null, node)){

            insertNode.data = key;

            //如果最后是空的，表示目前是颗空树
            if (node == null){
                treeNode = node;
            }
            if (key > node.data){
                node.rChild = insertNode;
            }else{
                node.lChild = insertNode;
            }
            return 1;
        }
        //该结点已经存在
        return 0;
    }


    public int  deleteBinaryTreeNode(BinaryTreeNode treeNode, int key){

        BinaryTreeNode node = null;

        //找到要删除的值
        if (1 == searchBinaryTreeNode(treeNode, key, null, node)){

            return 1;
        }
        return 0;
    }
}
