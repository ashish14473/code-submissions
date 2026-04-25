public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];
    }
}

class PrefixTree {
   private TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode curr = root;
        for(char c : chars){
            if(curr.children[c - 'a'] == null){
                TrieNode newNode  = new TrieNode();
                curr.children[c - 'a'] = newNode;
            }
            curr = curr.children[c - 'a'];  
        }
        curr.isEndOfWord = true;

    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode curr = root;
        for(char c : chars){
            if(curr.children[c - 'a'] == null){
               return false;
            }
            curr = curr.children[c - 'a'];  
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode curr = root;
        for(char c : chars){
            if(curr.children[c - 'a'] == null){
               return false;
            }
            curr = curr.children[c - 'a'];  
        }
        return true;

    }
}
