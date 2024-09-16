
import java.io.*;
import java.util.*;
//idea is to sort array based on start time
//then store end time in treeSet and compare start time of next element with first element in treeset which is minimum endtime value .
// if treeset value is <=start time then decrease counter.
//else increase counter
//return maximum value of counter

//time complexity n log n
//space complexity is o(n)
class MeetingRoom {
	public static void main(String[] args) {
		int[][] intervals = { { 10, 20 }, { 35, 50 }, { 15, 30 }, { 30, 40 } };

		System.out.println("Min no of meeting rooms required is " + findConferenceRoom(intervals));
	}

	public static int findConferenceRoom(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0])); //sorting based on start time
		TreeSet<Integer> treeSet = new TreeSet<>();
		int maxCount = 1;
		int count = 1;
		int i = 0;
		while (i < intervals.length - 1) {
			// int[] interval=intervals[i];
			treeSet.add(intervals[i][1]); //storing endtime in treeset
			i++;
			if (treeSet.first() > intervals[i][0]) { //compraing with  minimum value of endtime bz treeSet.first()
				count++;
				if (maxCount < count)
					maxCount = count;
			} else if (treeSet.first() <= intervals[i][0]) {
				count--;
			}
		}
		return maxCount;
	}
	
	
	
	/*public int minMeetingRooms(int[][] intervals) {
	    Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
	 
	    PriorityQueue<Integer> heap = new PriorityQueue<>();
	    int count = 0;
	    for (int[] itv : intervals) {
	        if (heap.isEmpty()) {
	            count++;
	            heap.offer(itv[1]);
	        } else {
	            if (itv[0] >= heap.peek()) {
	                heap.poll();
	            } else {
	                count++;
	            }
	 
	            heap.offer(itv[1]);
	        }
	    }
	 
	    return count;
	}*/
}
