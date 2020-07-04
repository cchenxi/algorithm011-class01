package com.cchenxi.w2.practice.n242;

import org.junit.Test;

import com.cchenxi.w2.practice.n242.ValidAnagram;

/**
 * Date: 2020-07-04
 *
 * @author chenxi
 */
public class ValidAnagramTest {

    @Test
    public void isAnagram() {
        String s = "cat";
        String t = "car";

        ValidAnagram validAnagram = new ValidAnagram();
        boolean result = validAnagram.isAnagram(s, t);
        System.out.println(result);
    }
}