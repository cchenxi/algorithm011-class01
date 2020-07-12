package com.cchenxi.w3.n78;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Date: 2020-07-12
 *
 * @author chenxi
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        return m1(nums);
    }

    private List<List<Integer>> m1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> list, int index) {
        //terminator
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        //current logic
        dfs(result, nums, list, index + 1);

        list.add(nums[index]);
        dfs(result, nums, list, index + 1);

        //drill down

        //reverse states
        list.remove(list.size() - 1);
    }
}
