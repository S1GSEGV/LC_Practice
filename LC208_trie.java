class Trie {

    /** Initialize your data structure here. */
    private static class TrieNode {
        TrieNode[] childrens = new TrieNode[26];
        int count = 0;
    }

    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    void insert(String word) {
        System.out.println("Insert: " + word);
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(node.childrens[chars[i] - 'a'] == null) {
                node.childrens[chars[i] - 'a'] = new TrieNode();
            }
            node = node.childrens[chars[i] - 'a'];
        }
        node.count++;

    }

    /** Returns if the word is in the trie. */
    boolean search(String word) {
        System.out.println("Search: " + word);

        if(word == null || word.length() == 0)
            return false;
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < chars.length; i++ ) {
            if(node.childrens[chars[i] - 'a'] != null) {
                node = node.childrens[chars[i] - 'a'];
            } else {
                return false;
            }
        }
        return node.count > 0;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    boolean startsWith(String prefix) {
        System.out.println("StartWith: " + prefix);

        if(prefix == null || prefix.length() == 0)
            return false;
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < chars.length; i++ ) {
            if(node.childrens[chars[i] - 'a'] != null) {
                node = node.childrens[chars[i] - 'a'];
            } else {
                return false;
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */