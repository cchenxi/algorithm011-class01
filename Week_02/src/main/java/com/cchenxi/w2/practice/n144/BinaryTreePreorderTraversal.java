package com.cchenxi.w2.practice.n144;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Date: 2020-07-04
 *
 * @author chenxi
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        return m1(root);
    }

    public List<Integer> m1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        help(root, result);
        return result;
    }

    public void help(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            if (root.left != null) {
                help(root.left, result);
            }
            if (root.right != null) {
                help(root.right, result);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
