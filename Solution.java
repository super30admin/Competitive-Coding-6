// Time Complexity :O(1);
// Space Complexity:O(1);

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowSeen = new boolean[9][9]; 
        boolean[][] colSeen = new boolean[9][9];
        boolean[][] subgridSeen = new boolean[9][9]; 
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    int num = val - 0-'1'; 
                    int subgridIdx = (i / 3) * 3 + (j / 3);
                    if (rowSeen[i][num] || colSeen[j][num] || subgridSeen[subgridIdx][num]) {
                        return false;
                    }
                    rowSeen[i][num] = true;
                    colSeen[j][num] = true;
                    subgridSeen[subgridIdx][num] = true;
                }
            }
        }
        return true;
    }
}
