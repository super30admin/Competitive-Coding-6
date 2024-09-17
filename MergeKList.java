 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, Integer> map = new HashMap<>();
    for(ListNode node: lists){
        while(node != null){
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            node = node.next;
        }
    }
    
    ListNode dummyHead = new ListNode(-1);
    ListNode prev = dummyHead;
    List<Integer> list = new ArrayList<>(map.keySet());
    Collections.sort(list);
    
    for(int i: list){
        int count = map.get(i);
        while(count != 0){
            ListNode cur = new ListNode(i);
            prev.next = cur;
            prev = cur;
            count--;
        }
    }
    
    return dummyHead.next;
    }
}
 
 