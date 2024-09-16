/*

Problems Faced: No
Solution Approach: Min Heap
Test case = "[ [0,30],[5,10],[15,20] ]"

Idea:
1. Sort the meetings in ascending order of their start time
2. Add the first meeting's end time into the Heap( MinHeap )
3. For every next meeting in the array, compare the start time of the meeting
with the end time of heap.
4. If it is less than, then we need a meeeting room. If it is greater then
we don't need a meeting room.
5. In the end, the size of heap is number of conference rooms required.


Did it run on Leetcode: It is a locked leet code question.
This is the first time I am trying my submission using JAVA. Your comments will help
me to improve my code.

*/


import java.util.*;
import java.lang.*;
import java.io.*;


class ConferenceRooms
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		int[][] meetings = new int[][]{{0, 30}, {5, 10}, {15, 20}};
		PriorityQueue<Integer> minEndTimes = new PriorityQueue<Integer>();
		Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
		minEndTimes.add(meetings[0][1]);
		for(int i=1;i<meetings.length;++i){
			if (minEndTimes.peek()<=meetings[i][0]){
				minEndTimes.poll();
			}
			minEndTimes.offer(meetings[i][1]);
		}
		
		System.out.println("The minimum number of required conferences are:"+minEndTimes.size());
		
	}
}