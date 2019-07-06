class Solution {
    
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
    
    Trie trie = new Trie();
    
    public List<String> findWords(char[][] board, String[] words) {
        for(String s : words)
            trie.insert(s);
        
        Set<String> result = new HashSet<>();
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                dfs(board, i, j, "", result);
        
        return Arrays.asList(result.toArray(new String[0]));
    }
    
    public void dfs(char[][] board, int row, int col, String s, Set<String> result){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return;
        if(board[row][col] == '\0')
            return;
        
        s += board[row][col];
        if(!trie.startsWith(s))
            return;
        
        if(trie.search(s))
            result.add(s);
        
        char c = board[row][col];
        board[row][col] = '\0';
        dfs(board, row, col + 1, s, result);
        dfs(board, row + 1, col, s, result);
        dfs(board, row, col - 1, s, result);
        dfs(board, row - 1, col, s, result);
        board[row][col] = c;
        
    }
}