package com.cchenxi.w2.n49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Date: 2020-07-04
 *
 * @author chenxi
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        return m1(strs);
    }

    /**
     * 排序数组
     * 采用和242题解法1相似的思路，将字符数组排序来判断是否是异位词
     *
     * 此处将排序字符数组转换成key,key相同的值add到value中。最后将map的value转换为所需结果
     *
     * @param strs
     * @return
     */
    public List<List<String>> m1(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] keys = str.toCharArray();
            Arrays.sort(keys);
            String key = String.valueOf(keys);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
