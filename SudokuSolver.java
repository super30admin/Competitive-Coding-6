public class SudokuSolver {
	public void solveSudoku(char[][] board) {

		backtrack(board);

	}

	private boolean backtrack(char[][] board){
           
       for(int i = 0;i<9;i++){
           for(int j = 0;j<9;j++){
               
               //action
               if(board[i][j]== "."){
                   for(int k = 1;k<=9;k++){
                       if(isValidSudoko(board,k,i,j)){    
                           board[i][j] = char(k + '0') ;
                               
                        //recurse
                      if(backtrack(board))
                          return true;
                           
                       //backtrack
                        board[i][j] = '.';  
                       
                       }
                                       
                   }
                   return false;
               } 
               
           }
       }
        return true;   
           
   }

}
