package com.cchenxi.w3.n105;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Date: 2020-07-12
 *
 * @author chenxi
 */
public class ConstructBinaryTreeFromPreAndInOrderTraversal {

    //preorder = [3,9,20,15,7]
    //inorder = [9,3,15,20,7]
    //不需要将数组切割 只需要用指针划定范围 左闭右开区间
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode help(int[] preorder ,int pStart, int pEnd, int[] inOrder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }
        //在前序遍历中找到根节点的位置
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);

        //在中序遍历中找到根节点的位置
        int iRootIndex = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (rootVal == inOrder[i]) {
                iRootIndex = i;
                break;
            }
        }
        //左子树的长度
        int leftNum = iRootIndex - iStart;

        root.left = help(preorder, pStart + 1, pStart + leftNum + 1, inOrder, iStart, iRootIndex);
        root.right = help(preorder, pStart + leftNum + 1, pEnd, inOrder, iRootIndex + 1, iEnd);
        return root;
    }
}
