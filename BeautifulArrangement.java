import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Time Complexity : Time O(n!)
//Space Complexity : Space O(n)
public class BeautifulArrangement {	
	/**Approach: Backtrack **/
	List<List<Integer>> list;
    public int countArrangement(int n) {
        if(n==1 || n==2) return n;  
        
        //find all comb 
        List<Integer> nums= new ArrayList<>();
        for(int i=0; i<n; i++){
            nums.add(i+1);
        }
        list=new ArrayList<>();        
        helper(nums, 0);
        
        return list.size();        
    }
    
    private void helper(List<Integer> nums, int index){
        //base
        if(index==nums.size()) {
        	System.out.println(nums);
            list.add(new ArrayList<>(nums));         
            return;
        }        
        //logic
        for(int i=index; i<nums.size(); i++){   
            //Action
            Collections.swap(nums, index, i);
            //Backtrack
            if(nums.get(index)%(index+1) == 0 || (index+1)%nums.get(index) == 0){
                helper(nums, index+1);
            }
            //Recurse
            Collections.swap(nums, index, i);            
        }
    } 
	
	// Driver code to test above 
	public static void main (String[] args) {
		BeautifulArrangement ob= new BeautifulArrangement();
		int n=3;
		System.out.println("No of beautiful permutation arrangements are: "+ob.countArrangement(n));
	}
}
