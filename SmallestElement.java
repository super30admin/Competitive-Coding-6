class Solution {
    int getPivot(int [] nums, int start, int end) {
        int [] medians = new int[(end - start) / 5];
        int i = start;
        int k = 0;
        for(int j = start + 5; j < end; i = j, j += 5) {
            Arrays.sort(nums,i,j);
            medians[k++] = nums[i + 2];
        }
       
	    // The magic!!! we are calling our own primary method recursively to find the median of medians.
        return kthSmallest(medians, 0, medians.length, medians.length/2 + 1);
    }
    
    int arrangeByPivot(int [] nums, int start, int end, int pivot) {
        int b = start;
        int e = end - 1;
        for(int i = start; i <= e;){
            if(nums[i] < pivot){
                int temp = nums[i];
                nums[i] = nums[b];
                nums[b] = temp;
                b++;
                i++;
            } else if(nums[i] == pivot){
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[e];
                nums[e] = temp;
                e--;
            }
        }
        
        return b;
    }
    
    int kthSmallest(int []nums, int start, int end, int elm) {
        if(end - start <= 5) {
            Arrays.sort(nums,start,end);
            return nums[start + elm - 1];
        }
        
		// find the pivot element that will split the 
		// set as evenly as possible - this is where all the magic happens
        int pivot = getPivot(nums,start, end);
		
		// perform a partition based on the pivot found.
        int loc = arrangeByPivot(nums,start, end, pivot);
		
		// check where is the element we are seeking compared to the partition index
		// call recursively depending on the partitioned location or return, if we have found the element
        if(loc - start == elm - 1){
            return nums[loc];
        } else if (loc - start > elm - 1){
            return kthSmallest(nums,start,loc,elm);
        } 
        
        return kthSmallest(nums,loc + 1, end, (elm - (loc + 1 -  start)));
    }
    
    public int findKthLargest(int[] nums, int k) {
        return kthSmallest(nums,0, nums.length, nums.length - k + 1);
    }
}