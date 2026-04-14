//
//  DesignLoggerRateLimiter.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/9/26.
//

/*
 time compelxity -> O(1)
 space complexity - O(n), hashmap for unique messages.
 We don't need to track all timestamps. Just the last timestamps for printed message
 If the new message exists in the hash map -> then check if lastTimeStamp - current >= 10, if yes, then print and update timestamp. Else skip
 If the new message doesn't exist in the timestamp then print the messahe and store in the hash map.
 
 */
class LoggerRateDelimiter {
    struct QueueUsingLinkedList<T> {
        class LLNode<T> {
            var value: T
            var next: LLNode<T>?
            init(value: T) {
                self.value = value
            }
        }
        
        private var front: LLNode<T>?
        private var rear: LLNode<T>?
        private var count: Int = 0
        
        mutating func enqueue(_ value: T) {
            let newNode = LLNode(value: value)
            if (front == nil) {
                front = newNode
                rear = newNode
            } else {
                rear?.next = newNode
                rear = newNode
            }
            count += 1
        }
        
        mutating func dequeue() -> T? {
            if (front == nil) {
                return nil
            }
            
            let val = front?.value
            front = front?.next
            if (front == nil) {
                rear = nil
            }
            count -= 1
            return val
        }
        
        var size: Int {
            return count
        }
        
        var isEmpty: Bool {
            return count == 0
        }
        
        var first: T? {
            return front?.value
        }
    }
    
    init() {
        
    }
    
    var map = Dictionary<String, Int>()
    var queue = QueueUsingLinkedList<(String, Int)>()
    

    func loggerRateDelimiter(_ message: String, timestamp: Int) -> Bool {
        while (!queue.isEmpty && timestamp - queue.first!.1 > 10) {
            //remove from the queue if the difference of timestamp is greater than 10
            let (msg, time) = queue.dequeue()!
            //if the same message exist in the map, then remove from the map as well
            if (map[msg] == time) {
                map.removeValue(forKey: msg)
            }
        }
        if (map[message] == nil) {
            map[message] = timestamp
            return true
        }
        if (timestamp - map[message]! >= 10) {
            map[message] = timestamp
            return true
        }
        
        return false
    }
    
    /*
     Follow up optimization - If memory is concern (huge stream) then periodically remove old entries
     use a queue + clean up system.
     Queue -> keeps messages in time order
     hash map -> stores lats printed timestamp.
     Because timestamps are monotonically increasing, we can remove outdated messages fromt he front (older than 10 seconds)
     This prevents map from growing forever.
     time complexity  along with queue - amortized O(1) per operation (each element added + removed once)
     space compelxity - O(k), where k = messages in last 10 seconds.
     */
}

