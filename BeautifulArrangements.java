//Time Complexity O(N!)
//Space Complexity O(N)
//leetCode tested
public class BeautifulArrangements {
    int result = 0;
    public int countArrangement(int n) {
        int[]nums = new int[n+1];
        backTrack(nums,1,n);
        return result;
    }
    private void backTrack(int[] nums,int index,int n){
        if(index == n+1){
            result++;
            return;
        }
        for(int i=1;i<n+1;i++){
            if(nums[i] == 0 && (index%i == 0 || i%index == 0)){
                //Action
                nums[i] = index;
                //Recurse
                backTrack(nums,index+1,n);
                //Backtrack
                nums[i] = 0;
            }
        }
    }

}
