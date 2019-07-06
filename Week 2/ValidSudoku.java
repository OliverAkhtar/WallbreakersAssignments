class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set;
        
        for(int r = 0; r < 9; r++){
            set = new HashSet<Character>();
            for(int c = 0; c < 9; c++)
                if(board[r][c] != '.')
                    if(!set.add(board[r][c]))
                        return false;
        }
        
        for(int c = 0; c < 9; c++){
            set = new HashSet<Character>();
            for(int r = 0; r < 9; r++)
                if(board[r][c] != '.')
                    if(!set.add(board[r][c]))
                        return false;
        }
        
        for(int i = 0; i < 9; i += 3)
            for(int j = 0; j < 9; j += 3){
                set = new HashSet<Character>();
                for(int r = i; r < i + 3; r++)
                    for(int c = j; c < j + 3; c++)
                        if(board[r][c] != '.')
                            if(!set.add(board[r][c]))
                                return false;
            }
        
        return true;    
    }
}