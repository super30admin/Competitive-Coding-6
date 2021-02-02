//Time Complexity - o(k) k is no of valid permutations
//Space Complexity - o(n)
public class BeautifulArrangements {

	    int count;
	    boolean [] seen;
	    public int countArrangement(int n) {
	        seen = new boolean[n+1];
	        //starting index will be 1 instead of 0
	        helper(n,1,seen);
	        //return count
	        return count;
	    }
	    
	    private void helper(int n,int index,boolean [] seen){
	        //base
	        //if we could place all the elements add count by one
	        if(index == n+1){
	            count++;
	        }
	        //logic
	        for(int i=1;i<=n;i++) {
	            //if index is not visited and one of the modulo condition is true do action recurse 
	            if((i%index == 0 || index%i == 0) && !seen[i]){
	                //action
	                seen[i] = true;
	                //recurse
	                helper(n,index+1,seen);
	                //after traversing the particular path backtrack by making seen as false
	                //backtrack
	                seen[i] = false;
	            }
	        }
	        
	    }

}
