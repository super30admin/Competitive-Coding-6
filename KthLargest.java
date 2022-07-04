//Time O(nlogn)
//Space O(n)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>(){
            
            public int compare(Integer a , Integer b){
                return a-b;
            }
        });
        
     for(int i :nums)
     {
         
         q.add(i);
       
         
     }
        
    for( int i =0;i<nums.length-k;i++)
        q.poll();
        
    return q.poll();
        
    }
}