package com.cchenxi.w7.n208ImplementsTriePrefixTree;

/**
 * Date: 2020-08-27
 *
 * @author chenxi
 */
public class TrieNode {
    TrieNode[] children;
    boolean isWord;
    String word;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
        word = "";
    }
}
