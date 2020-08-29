package com.cchenxi.w7.n212WordSearch2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Date: 2020-08-29
 *
 * @author chenxi
 */
public class Solution_1_1 implements WordSearch2 {
    private static final char END_OF_WORD = '@';

    //用于四连通图的遍历
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    @Override
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return Collections.emptyList();
        }

        //将words放到字典树中
        Trie trie = new Trie();
        TrieNode root = trie.root;
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> result = new HashSet<>();
        //word search
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, Set<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return;
        }
        char word = board[i][j];

        //不在trie树的当前层级
        if (word == END_OF_WORD || root.children[word - 'a'] == null) {
            return;
        }

        root = root.children[word - 'a'];
        if (root.isWord) {
            result.add(root.word);
        }

        board[i][j] = END_OF_WORD;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(board, x, y, root, result);
        }

        board[i][j] = word;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    String word;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
        word = "";
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
        node.word = word;
    }
}
