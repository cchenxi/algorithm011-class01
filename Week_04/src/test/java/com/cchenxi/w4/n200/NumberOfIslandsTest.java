package com.cchenxi.w4.n200;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 2020-07-19
 *
 * @author chenxi
 */
public class NumberOfIslandsTest {
    private NumberOfIslands numberOfIslands;
    private final char[][] array = new char[][]
            {
                    {'1','1','0','0','0'},
                    {'1','1','0','0','0'},
                    {'0','0','1','0','0'},
                    {'0','0','0','1','1'}
            };

    @Before
    public void setUp() throws Exception {
        numberOfIslands = new NumberOfIslands();
    }

    @Test
    public void numIslands() {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int nums = numberOfIslands.numIslands(array);
        System.out.println(nums);
    }
}