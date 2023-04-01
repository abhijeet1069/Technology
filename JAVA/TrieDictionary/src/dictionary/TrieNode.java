package dictionary;

/**
 In tries, we see that each unique path is a unique word. Here, we can't have a cycle.
 For ex : 'DW' and 'CW'. Although, both words end with a common 'W', in trie both 'W' are different.
 * */

public class TrieNode {
    TrieNode[] children;
    boolean isEndWord;
    String meaning;
    static final int ALPHABET_SIZE = 26;
    TrieNode(){
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }
    public void markAsLeaf(){
        this.isEndWord = true;
    }
    public void unMarkAsLeaf(){
        this.isEndWord = false;
    }
}
