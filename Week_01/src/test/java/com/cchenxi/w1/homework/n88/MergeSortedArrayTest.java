package com.cchenxi.w1.homework.n88;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 2020-06-29
 *
 * @author chenxi
 */
public class MergeSortedArrayTest {

    @Test
    public void merge() {
        int[] nums1 = {4, 5, 6, 0, 0, 0, 0, 0};
        int[] nums2 = {7, 8, 9};
        int m = 3, n = 3;

        MergeSortedArray cl = new MergeSortedArray();
        cl.merge(nums1, m, nums2, n);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}