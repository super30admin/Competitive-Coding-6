//TC: O(n*n)
//SC: O(n)
//n=9
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set=new HashSet<>();
        int n=board.length;
        for(int i=0;i<n;i++)
        {
          for(int j=0;j<n;j++)
          {
                   if(board[i][j]!='.')
                  {
             if(!set.contains(board[i][j]))
               set.add(board[i][j]);
              else
              {
                  return false;
              }
                  }

          }
             set.clear();
        }
     
        for(int j=0;j<n;j++) 
        {
        for(int i=0;i<n;i++)
          {
              
            if(board[i][j]!='.')
            {
             if(!set.contains(board[i][j]))
               set.add(board[i][j]);
              else
              {
                  return false;
              }
            }
          }
             set.clear();
        }
     
    for(int i=0;i<n;i=i+3)
    {
        for(int j=0;j<n;j=j+3)
        {
            for(int i1=i;i1<i+3;i1++)
            {
                for(int j1=j;j1<j+3;j1++)
                {
                  if(board[i1][j1]!='.')
                    {
                    if(!set.contains(board[i1][j1]))
                    {
                        set.add(board[i1][j1]);
                    }
                    else
                    {
                        return false;
                    }
                    }
                }
            }
            set.clear();
        }
    }
    return true;
    }
}