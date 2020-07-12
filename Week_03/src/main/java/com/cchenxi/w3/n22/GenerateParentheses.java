package com.cchenxi.w3.n22;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Date: 2020-07-09
 *
 * @author chenxi
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        return m1(n);
    }

    public List<String> m1(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result);
        return result;
    }

    private void generate(int left, int right, int n, String s, List<String> result) {
        //terminator
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        //process current logic

        //drill down
        if (left < n) {
            generate(left + 1, right, n, s + "(", result);
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")", result);
        }

        //reverse states
    }
}
