package com.cchenxi.w2.practice.n94;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Date: 2020-07-04
 *
 * @author chenxi
 */
public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        return m1(root);
    }

    /**
     * 递归遍历
     *
     *
     * @param root
     * @return
     */
    public List<Integer> m1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        help(root, result);
        return result;
    }

    public void help(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                help(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                help(root.right, list);
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
