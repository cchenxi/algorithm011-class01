package com.cchenxi.w1.homework;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 使用Deque Api改写demo代码
 * Date: 2020-06-27
 *
 * @author chenxi
 */
public class DequeDemo {
    public void useOldApi() {
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

    public void useNewApi() {
        Deque<String> deque = new LinkedList<>();

        //代替push
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }

    public static void main(String[] args) {
        DequeDemo dequeDemo = new DequeDemo();
        dequeDemo.useOldApi();
        dequeDemo.useNewApi();
    }
}
