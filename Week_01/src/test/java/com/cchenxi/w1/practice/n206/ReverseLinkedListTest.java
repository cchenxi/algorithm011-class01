package com.cchenxi.w1.practice.n206;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 2020-07-08
 *
 * @author chenxi
 */
public class ReverseLinkedListTest {

    @Test
    public void reverseList() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        head.next = new ReverseLinkedList.ListNode(2);
        head.next.next = new ReverseLinkedList.ListNode(3);
        ReverseLinkedList c = new ReverseLinkedList();
        c.reverseList(head);

        System.out.println(1);
    }
}