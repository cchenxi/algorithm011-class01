package com.cchenxi.w4.n55;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 2020-07-19
 *
 * @author chenxi
 */
public class JumpGameTest {

    @Test
    public void canJump() {
        JumpGame jumpGame = new JumpGame();
        boolean can = jumpGame.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(can);
    }
}