package com.cchenxi.w1.n1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 2020-06-27
 *
 * @author chenxi
 */
public class TwoSumTest {

    @Test
    public void twoSum() {
        TwoSum c = new TwoSum();
        int[] result = c.twoSum(new int[]{2, 7, 11, 15}, 20);
        System.out.println(result);
    }
}