package com.cchenxi.w1.practice.n1;

import org.junit.Test;

/**
 * Date: 2020-06-27
 *
 * @author chenxi
 */
public class TwoSumTest {

    @Test
    public void twoSum() {
        TwoSum c = new TwoSum();
        int[] result = c.twoSum(new int[]{2, 7, 11, 15, 5}, 21);
        System.out.println(result);
    }
}