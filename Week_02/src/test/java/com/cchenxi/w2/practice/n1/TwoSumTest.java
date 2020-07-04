package com.cchenxi.w2.practice.n1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 2020-07-04
 *
 * @author chenxi
 */
public class TwoSumTest {

    @Test
    public void twoSum() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int[] result = twoSum.twoSum(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}