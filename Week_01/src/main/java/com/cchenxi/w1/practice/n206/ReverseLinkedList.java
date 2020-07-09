package com.cchenxi.w1.practice.n206;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2020-07-08
 *
 * @author chenxi
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return m1(head);
    }

    public ListNode m1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;

        while (cur != null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //将当前节点指向pre
            cur.next = pre;
            //将pre和cur节点向前移动一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
