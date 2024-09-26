
// Time Complexity : O(1)
// Space Complexity : O(capacity)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Logger {
    
    class ListNode {
        ListNode prev;
        ListNode next;
        String message;
        int timestamp;
        
        public ListNode(int timestamp, String message) {
            this.message = message;
            this.timestamp = timestamp;
        }
    }
    HashMap<String, ListNode> map;
    int capacity;
    ListNode head;
    ListNode tail;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap();
        head = new ListNode(0,"");
        tail = new ListNode(0,"");
        head.next = tail;
        tail.prev = head;
    }
    
    public void moveToHead(ListNode temp, int timestamp) {
        temp.timestamp = timestamp;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = head.next;
        temp.prev = head;
        head.next = temp;
        temp.next.prev = temp;
    }
    
    public void addToHead(int timestamp, String message) {
        ListNode newNode = new ListNode(timestamp, message);
        newNode.next = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next.prev = newNode;
        map.put(message, newNode);
    }
    
    public void removeTail() {
        this.tail.prev.next = this.tail.next;
        this.tail.next.prev = this.tail.prev;
        map.remove(this.tail.message);
    }
    
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)) {
            ListNode node = map.get(message);
            if(timestamp - node.timestamp < 10) {
                return false;  
            }
            moveToHead(node, timestamp);
        } else {
            if(map.size() >= 10) {
                removeTail();
            }
            addToHead(timestamp,message);
        }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */



// Time Complexity : O(k) where k is the number of ans available
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int result;
    public int countArrangement(int n) {
        result = 0;
        if(n == 0) {
            return 0;
        }
        int[] nums = new int[n+1];
        helper(n, 1, nums);
        return result;
    }
    
    private void helper(int n,int position, int[] nums) {
        if(position > n) {
            System.out.println(Arrays.toString(nums));
            result++;
            
        }
        for(int i = 1; i <= n; i++) {
            if(nums[i] == 0 && (i % position == 0 || position % i == 0)) {
                nums[i] = position;
                helper(n, position + 1, nums);
                nums[i] = 0;
            }
        }
    }
}