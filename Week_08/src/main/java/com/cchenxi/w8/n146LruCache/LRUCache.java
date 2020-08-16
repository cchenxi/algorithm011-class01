package com.cchenxi.w8.n146LruCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2020-08-15
 *
 * @author chenxi
 */
public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        if (node != tail) {
            //头结点（最旧的），更新头结点
            if (node == head) {
                head = head.next;
            }
            //中间节点 把它取出来，连接它的前后节点
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        //已经存在这个node
        if (node != null) {
            //更新node的value
            node.value = value;
            if (node != tail) {
                //头结点（最旧的），更新头结点
                if (node == head) {
                    head = head.next;
                }
                //中间节点 把它取出来，连接它的前后节点
                else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }
        }
        //不存在这个node，需要插入新的节点
        else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                //map中移除
                map.remove(head.key);
                //删除head节点
                head = head.next;
                //容量增加1
                capacity++;
            }
            //第一个节点
            if (head == null && tail == null) {
                head = newNode;
            }
            //非第一个节点
            else {
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }
}
