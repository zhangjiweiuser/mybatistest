package com.zhang.mybatis.entity;

/**
 * @ClassName BinaryTree
 * @Author zhangjiwei
 * @Date 2019/8/19 9:56
 * @Description
 */
public class BinaryTree implements Tree {

    private TreeNode root;

    @Override
    public TreeNode find(int key) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.getData() > key) {
                curr = curr.getLeftChild();
            } else if (curr.getData() < key) {
                curr = curr.getRightChild();
            } else {
                return curr;
            }
        }
        return null;
    }

    @Override
    public boolean insert(int data) {
        TreeNode newNode = new TreeNode(data);
        // 当前树为空树，没有任何节点
        if (root == null) {
            root = newNode;
            return true;
        } else {
            TreeNode curr = root;
            TreeNode parentNode = null;
            while (curr != null) {
                parentNode = curr;
                if (curr.getData() > data) {
                    curr = curr.getLeftChild();
                    if (curr == null) {
                        parentNode.setLeftChild(newNode);
                        return true;
                    }
                } else {
                    curr = curr.getRightChild();
                    if (curr == null) {
                        parentNode.setRightChild(newNode);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void infixOrder(TreeNode current) {
        if (current != null) {
            infixOrder(current.getLeftChild());
            System.out.print(current.getData() + "  ");
            infixOrder(current.getRightChild());
        }
    }

    @Override
    public void preOrder(TreeNode current) {
        if (current != null) {
            System.out.print(current.getData() + "  ");
            preOrder(current.getLeftChild());
            preOrder(current.getRightChild());
        }
    }

    @Override
    public void postOrder(TreeNode current) {
        if (current != null) {
            postOrder(current.getLeftChild());
            postOrder(current.getRightChild());
            System.out.print(current.getData() + "  ");
        }
    }

    @Override
    public TreeNode findMax() {
        TreeNode curr = root;
        TreeNode max = curr;
        while (curr != null) {
            max = curr;
            curr = curr.getRightChild();
        }
        return max;
    }

    @Override
    public TreeNode findMin() {
        TreeNode curr = root;
        TreeNode min = curr;
        while (curr != null) {
            min = curr;
            curr = curr.getLeftChild();
        }
        return min;
    }

    @Override
    public boolean delete(int key) {
        TreeNode curr = root;
        TreeNode parent = root;
        boolean isLeftChild = false;
        while (curr.getData() != key) {
            parent = curr;
            if (curr.getData() > key) {
                isLeftChild = true;
                curr = curr.getLeftChild();
            } else {
                isLeftChild = false;
                curr = curr.getRightChild();
            }
            if (curr == null) {
                return false;
            }
        }
        return false;
    }
}
