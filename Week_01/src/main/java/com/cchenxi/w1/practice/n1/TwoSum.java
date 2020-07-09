package com.cchenxi.w1.practice.n1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * tag: 数组 哈希表（map）
 *
 * Date: 2020-06-26
 *
 * @author chenxi
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return m3(nums, target);
    }

    /**
     * 暴力求解
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] m1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    public int[] m2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("no Solution");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && i != map.get(other)) {
                return new int[]{i, map.get(other)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no Solution");
    }

    public int[] m3(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("no solution");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && i != map.get(other)) {
                return new int[]{i, map.get(other)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution");
    }
}
