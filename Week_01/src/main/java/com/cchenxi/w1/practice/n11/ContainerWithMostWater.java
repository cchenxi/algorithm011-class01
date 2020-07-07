package com.cchenxi.w1.practice.n11;

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

    /**
     * 二刷
     *
     * 思路
     * 双指针
     * i从前向后
     * j从后向前
     * 取height[i]和height[j]中较小的值作为高，并且向中间移动一位
     * 计算面积 长=j-i+1，+1是因为上述操作向中间移动了一位，所以要再加回来
     *
     * @param height
     * @return
     */
    public int m3(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int h = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * h;
            max = Math.max(max, area);
        }
        return max;
    }
}
