package dictionary;

public class Trie {
    private TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    public int getIndex(char t){
        return t-'a';
    }
    public TrieNode getRoot(){
        return root;
    }
    public void insert(String key,String meaning){
        if(key == null){
            return;
        }
        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;
        for(int level=0; level<key.length(); level++){
            index = getIndex(key.charAt(level));
            if(currentNode.children[index] == null){
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.markAsLeaf();
        currentNode.meaning = meaning;
    }
    public TrieNode search(String key){
        if(key == null){
            return null;
        }
        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;
        for(int level=0; level<key.length(); level++){
            index = getIndex(key.charAt(level));
            if(currentNode.children[index] == null){
                return null;
            }
            currentNode = currentNode.children[index];
        }
        if(currentNode.isEndWord){
            return currentNode;
        }
        return null;
    }
}
