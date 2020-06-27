package com.cchenxi.w1.n283;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 2020-06-24
 *
 * @author chenxi
 */
public class MoveZerosTest {

    @Test
    public void moveZeroes() {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeros.m2(nums);
    }
}