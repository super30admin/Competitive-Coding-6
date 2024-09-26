// https://leetcode.com/problems/find-median-from-data-stream/

// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
/*
Maintain two queues which stores one half of the elements in sorted order
The queues shold always be balanced - > The difference in the number of elements in both
the queues should be at the max 1

if sum of number of elements in both the queues is even :
    Peek the elements from both the queues and find their average
else
    return the top element in the queue which has more elements.

*/
class MedianFinder {

    PriorityQueue<Integer> q1;
    PriorityQueue<Integer> q2;
    public MedianFinder() {
        q1 = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        q2 = new PriorityQueue<>();
    }

    // Time Complexity : O(log(n))
    public void addNum(int num) {
        if (q1.isEmpty()) {
            q1.add(num);
            return;
        }

        if (num > q1.peek()) {
            q2.add(num);
        } else {
            q1.add(num);
        }

        if (Math.abs(q1.size() - q2.size()) > 1) {
            if (q1.size() > q2.size()) {
                q2.add(q1.poll());
            } else {
                q1.add(q2.poll());
            }
        }
    }
    // Time Complexity : O(1)
    public double findMedian() {
        int n = q1.size() + q2.size();
        if (n % 2 == 0)
            return (q1.peek() + q2.peek()) / 2.0;

        if (q1.size() > q2.size())
            return q1.peek();
        else
            return q2.peek();

    }
}
