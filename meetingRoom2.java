//Time Complexity:O(NlogN)
//Space Complexity:O(N)
//In this problem, I'll be sorting the given list using custom sort according to the start time of the meetings. After Sorting, I'll be creting a min heap that will hold the earliest ending meeting.I'll keep removing the elements from the min heap when the earliest ending meeting ends before my next meeting starts. So I dont require an additional room, hence I'll be popping that and add my next meeting into the heap. If there's a meeting that starts before my current meeting ends, I'll be straight away adding that meeting to my heap. At the end my heap size will tell me the number of meeting rooms required.
//This code was executed successfully and got accepted in leetcode. 

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0||intervals==null){
            return 0;
        }
        Comparator<int[]> c=(int[]a,int[]b)->(a[0]-b[0]);
        Arrays.sort(intervals,c);
        PriorityQueue<int[]> minHeap=new PriorityQueue<int[]>((int[]a,int[]b)->(a[1]-b[1]));
        for(int[] interval:intervals){
            if(!minHeap.isEmpty()&&minHeap.peek()[1]<=interval[0]){
                minHeap.poll();
            }
            minHeap.add(interval);
        }
        return minHeap.size();
    }
}