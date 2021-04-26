package src.edu.workout;

//Time Complexity - O(n!) - worst case all valid Permutations will be calculated
//Space Complexity - O(n) - n is the inout n - for the boolean[]
//Approach - Backtracking - all valid permutations will be calculated to assign a position for each number from 1-n
// if all the numbers are not successfully placed in a position, then we dont choose that path
//come back (backtrack) and start with a new arrangement

public class BeautifulArrangement {

  static int result = 0;
  static boolean[] visited;
  public static int arrangement(int n){
    if(n < 1){
      return n;
    }

    visited = new boolean[n+1]; // n will start from 1 , if its 4 (0,1,2,3,4) - 5
    backtrack(n, visited, 0);

    return result;
  }

  public static void backtrack(int n, boolean[] visited, int index){

    //base case - when to stop or when to add to the result
    if(index > n){
      result++;
    }

    for(int i=1; i<=n; i++){
      if(!visited[i] && (index % i == 0 || i % index == 0)) {
        //choose
        visited[i] = true;
        //backtrack
        backtrack(n, visited, i + 1);
        //not choose
        visited[i] = false;
      }
    }


  }

  public static void main(String[] args) {

    int input = 3;

    System.out.println("RESULT: "+arrangement(input));
  }

}
