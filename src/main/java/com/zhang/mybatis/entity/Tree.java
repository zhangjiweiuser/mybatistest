package com.zhang.mybatis.entity;

/**
 * @ClassName Tree
 * @Author zhangjiwei
 * @Date 2019/8/19 9:54
 * @Description
 */
public interface Tree {

    TreeNode find(int key);

    boolean insert(int data);

    void infixOrder(TreeNode current);

    void preOrder(TreeNode current);

    void postOrder(TreeNode current);

    TreeNode findMax();

    TreeNode findMin();

    boolean delete(int key);
}
