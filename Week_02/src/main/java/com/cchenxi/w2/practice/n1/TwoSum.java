package com.cchenxi.w2.practice.n1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Date: 2020-07-04
 *
 * @author chenxi
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return m3(nums, target);
    }

    /**
     * 暴力 遍历数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] m1(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[2];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    /**
     * 两遍哈希
     *
     * 第一遍 遍历数组 组装map key=元素，value=元素位置
     * 第二变 遍历数组 target-nums[i]是否在map的key中，且是否和当前数组下标相同
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] m2(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[2];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && i != map.get(other)) {
                return new int[]{i, map.get(other)};
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    /**
     * 一遍哈希法
     *
     * 遍历数组，other = target - nums[i]是否也在map的keys中，如果在的话，则i和map.get(other)即为结果
     * 否则，将{nums[i], i}放进map中
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] m3(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[2];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{i, map.get(other)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution");
    }
}
