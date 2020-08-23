package com.cchenxi.w9.n151ReverseWordsInAString;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Date: 2020-08-22
 *
 * @author chenxi
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        return m2(s);
    }

    /**
     * reverse reverse
     *
     * @param s
     * @return
     */
    private String m2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] words = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + (i == 0 ? "" : " "));
        }
        return sb.toString();
    }

    /**
     * trim split reverse join
     *
     * @param s
     * @return
     */
    private String m1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
