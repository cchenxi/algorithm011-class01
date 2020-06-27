package com.cchenxi.w1.n11;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * tag: 数组
 *
 * Date: 2020-06-26
 *
 * @author chenxi
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        return m2(height);
    }

    public int m1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = calcArea(i, j, height);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    private int calcArea(int i, int j, int[] height) {
        return (j - i) * Math.min(height[i], height[j]);
    }

    public int m2(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }
}
