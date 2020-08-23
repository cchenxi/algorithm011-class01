package com.cchenxi.w9.n541ReverseString2;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 * <p>
 * 提示：
 * <p>
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Date: 2020-08-22
 *
 * @author chenxi
 */
public class ReverseString2 {
    public String reverseStr(String s, int k) {
        return m1(s, k);
    }

    private String m1(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        //每2k个一组循环
        for (int start = 0; start < chars.length; start += 2 * k) {
            reverse(chars, start, Math.min(start + k - 1, chars.length - 1));
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
