class Trie {
    
    class Node {
        char letter;
        Node[] children;
        boolean terminates;
        
        public Node(char letter, boolean terminates) {
            this.letter = letter;
            this.terminates = terminates;
            children = new Node[26];
        }
    }
    
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node((char) 0, false);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node n = root;
        int index = 0;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            index = c - 'a';
            if(n.children[index] == null)
                n.children[index] = new Node(c, false);
            n = n.children[index];
        }
        
        n.terminates = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node n = root, child = null;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            child = n.children[c - 'a'];
            if(child == null || child.letter != c)
                return false;
            n = child;
        }
        
        return n.terminates;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node n = root, child = null;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            child = n.children[c - 'a'];
            if(child == null || child.letter != c)
                return false;
            n = child;
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