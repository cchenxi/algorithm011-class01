package com.cchenxi.w2.n94;

import java.util.List;

import org.junit.Test;

/**
 * Date: 2020-07-04
 *
 * @author chenxi
 */
public class BinaryTreeInOrderTraversalTest {
    @Test
    public void inorderTraversal() {
        BinaryTreeInOrderTraversal binaryTreeInOrderTraversal = new BinaryTreeInOrderTraversal();
        BinaryTreeInOrderTraversal.TreeNode root = new BinaryTreeInOrderTraversal.TreeNode(1);
        root.left = null;
        BinaryTreeInOrderTraversal.TreeNode right = new BinaryTreeInOrderTraversal.TreeNode(2);
        BinaryTreeInOrderTraversal.TreeNode rightLeft = new BinaryTreeInOrderTraversal.TreeNode(3);
        right.left = rightLeft;
        root.right = right;
        List<Integer> result = binaryTreeInOrderTraversal.inorderTraversal(root);
        System.out.println(result);
    }
}