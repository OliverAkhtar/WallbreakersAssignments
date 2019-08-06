class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0)
            return false;
        
        boolean found = false;
        
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                found = search(board, word, i, j, 0);
                if(found)
                    return true;
            }
        
        return false;
    }
    
    public boolean search(char[][] board, String word, int r, int c, int count){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return false;
        if(board[r][c] == '\0')
            return false;
        boolean found = false;
        if(board[r][c] == word.charAt(count)){
            if(count == word.length() - 1)
                return true;
            
            board[r][c] = '\0';
            found = search(board, word, r, c + 1, count + 1) || 
                            search(board, word, r + 1, c, count + 1) ||
                            search(board, word, r - 1, c, count + 1) ||
                            search(board, word, r, c - 1, count + 1);
            
            board[r][c] = word.charAt(count);
        }
        
        return found;
    }
}