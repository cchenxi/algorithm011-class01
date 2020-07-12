package com.cchenxi.w3.n98;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 2020-07-12
 *
 * @author chenxi
 */
public class ValidateBinarySearchTreeTest {
    @Test
    public void isValidBST() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode4.left = treeNode3;
        treeNode4.right = treeNode6;
        treeNode5.left = treeNode1;
        treeNode5.right = treeNode4;

        ValidateBinarySearchTree c = new ValidateBinarySearchTree();
        System.out.println(
                c.isValidBST(treeNode5));
    }
}
