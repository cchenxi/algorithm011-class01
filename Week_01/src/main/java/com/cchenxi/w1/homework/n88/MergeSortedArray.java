package com.cchenxi.w1.homework.n88;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Date: 2020-06-29
 *
 * @author chenxi
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m3(nums1, m, nums2, n);
    }

    /**
     * 合并后再排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void m1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1, 0, m + n);
    }

    public void m2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int p = 0, i = 0, j = 0;
        while (i < m && j < n) {
            nums1[p++] = nums1Copy[i] < nums2[j] ? nums1Copy[i++] : nums2[j++];
        }

        if (i < m) {
            System.arraycopy(nums1Copy, i, nums1, i + j, m + n - i - j);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, i + j, m + n - i - j);
        }
    }

    /**
     * 双指针 从后往前
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void m3(int[] nums1, int m, int[] nums2, int n) {
        //nums1最终结果各元素索引
        int p = m + n -1;
        //从后往前各原始数组的起始索引
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            //比较 较大值存储到p位置，同时指针向前移动一位
            nums1[p--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        if (j + 1 > 0) {
            //如果nums1先走完（i = -1），需要将nums2的元素补上
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }
}
