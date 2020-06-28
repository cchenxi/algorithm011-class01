package com.cchenxi.w1.homework.n189;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Date: 2020-06-27
 *
 * @author chenxi
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        m2(nums, k);
    }

    /**
     * 暴力求解
     *
     * @param nums
     * @param k
     */
    public void m1(int[] nums, int k) {
        int tmp, pre;
        for (int i = 0; i < k; i++) {
            pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = pre;
                pre = tmp;
            }
        }
    }

    /**
     * 使用额外的数组
     *
     * 确定新数组每个元素的位置（i + k）% length = newIndex
     * 数组复制
     *
     * @param nums
     * @param k
     */
    public void m2(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i + k) % nums.length] = nums[i];
        }

        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }

    //环状替代 && 反转
    public void m3(int[] nums, int k) {

    }
}
