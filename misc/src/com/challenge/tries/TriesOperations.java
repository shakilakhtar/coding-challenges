package com.challenge.tries;

public class TriesOperations {
    private TrieNode root;

    public TriesOperations() {
        root=new TrieNode();
    }

    public boolean search(String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.child[index] == null) {
                return false;
            }
            current = current.child[index];
        }
        return current.isEnd;
    }

    public void insert(String key) {

        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.child[index] == null) {
                current.child[index] = new TrieNode();
            }

            current = current.child[index];
        }
        current.isEnd = true;
    }

    public TrieNode deleteKey(TrieNode root, String key, int i) {

        if (root == null) {
            return null;
        }
        if (i == key.length()) {

            root.isEnd = false;
            if (isEmpty(root) == true) {

                root = null;
            }
            return root;
        }
        int index = key.charAt(i) - 'a';
        root.child[index] = deleteKey(root.child[index], key, i + 1);
        if (isEmpty(root) && root.isEnd == false) {
            root = null;
        }
        return root;
    }

    public boolean isEmpty(TrieNode root) {

        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TriesOperations ops = new TriesOperations();
        ops.insert("Hello");
        System.out.println(ops.search("Hello"));
    }
}
