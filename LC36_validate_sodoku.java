class Solution {
    public boolean validateBlock(char[][] board, int row, int col){
        int endI = row + 3;
        int endJ = col + 3;
        
        HashSet<Character> set = new HashSet<Character>();
        for(int i = row; i < endI; i++) {
            for(int j = col; j < endJ; j++) {
                if(board[i][j] == '.') {
                    continue;
                } else {
                     if(set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        //validate Row
        for(int i = 0; i < 9; i++) {
            char[] row = board[i];
            set.clear();
            for(int j = 0; j < 9; j++) {
                if(row[j] == '.') {
                    continue;
                } else {
                    if(set.contains(row[j])) {
                        return false;
                    } else {
                        set.add(row[j]);
                    }
                }
            }
        }
        
        //Validate Colum
        set.clear();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char col = board[j][i];
                if(col == '.')
                    continue;
                else{
                    if(set.contains(col)) {
                        return false;
                    } else {
                        set.add(col);
                    }
                }
            }
            set.clear();
        }

        //Validate 9 blockes
        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j < 9; j +=3){
                if(!validateBlock(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}