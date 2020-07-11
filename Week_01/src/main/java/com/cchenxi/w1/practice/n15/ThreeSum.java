package com.cchenxi.w1.practice.n15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Date: 2020-07-11
 *
 * @author chenxi
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        return m1(nums);
    }

    /**
     * 暴力解法
     * 三重循环
     * 注意去重
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> m1(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums == null || nums.length < 3) {
            //注意 不合法的场景也需要返回list
            return new ArrayList<>(result);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
