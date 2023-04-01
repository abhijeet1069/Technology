package dictionary;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("a","First letter in alphahet");
        trie.insert("ab","Two contiguous letters");
        trie.insert("abc","Three contiguous letters");

        TrieNode node =  trie.search("abc");
        if(node!= null)
            System.out.println(node.meaning);

    }
}
