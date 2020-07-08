package com.cchenxi.w1.homework.n283;

import org.junit.Test;

/**
 * Date: 2020-06-24
 *
 * @author chenxi
 */
public class MoveZerosTest {

    @Test
    public void moveZeroes() {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = new int[]{1, 23, 0, 1, 0, 3, 12};
        moveZeros.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}