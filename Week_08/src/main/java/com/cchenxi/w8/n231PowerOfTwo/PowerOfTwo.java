package com.cchenxi.w8.n231PowerOfTwo;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Date: 2020-08-15
 *
 * @author chenxi
 */
public class PowerOfTwo {

    /**
     * 使用位运算计算
     * 一个整数如果是2的幂次方，则这个整数必定 >= 0
     * 且转换为2进制后只有其中一位为1，于是可以用 n & (n-1)移除最后的1，看处理过的数是否等于0
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
