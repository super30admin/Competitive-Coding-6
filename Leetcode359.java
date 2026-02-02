//Solution 1 - Using Queue and HashSet
// TC - O(1) amortized
// SC - O(m) m = number of unique messages in last 10 seconds.
class Logger {
    class Log { // Create a Log object with timestamp and message
        private int timestamp;
        private String message;

        public Log(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }

    Queue<Log> queue; // Use queue as FIFO to keep track of all the Log items
    HashSet<String> set; // maintain a set of message's that are only in last 10 timestamps.

    public Logger() {
        this.queue = new LinkedList<>();
        this.set = new HashSet<>();
    }

    public void removeOldLogs(int timestamp) {
        boolean remove = true;
        while (remove) {
            Log current = queue.peek();
            if (current != null && timestamp - current.timestamp >= 10) {
                Log log = queue.poll();
                set.remove(log.message);

            } else {
                remove = false;
            }
        }
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Node current = new Node();
        // Process current timestamp
        if (!set.contains(message)) { // if the set already contains message
            // Remove all the outdated logs
            removeOldLogs(timestamp); // remove all the outdated logs.

            set.add(message); // add the message to the set
            Log log = new Log(timestamp, message); // create a log object
            queue.add(log); // add it to the queue
            return true; // happy case
        } else { // message already present in the set
            removeOldLogs(timestamp); // remove all the outdated logs
            if (set.contains(message)) { // after removing items in queue and set, check if message is still present in
                                         // the set. If present return false
                return false;
            } else { // Else condition, message has been removed from queue and set.
                Log log = new Log(timestamp, message);
                queue.add(log); // Add it back to the queue with new timestamp
                set.add(message); // add it back to the set.
                return true;
            }

        }

    }
}

// Solution 2 - Using HashMap
// TC - O(1)
// SC - O(m) m = number of unique messages in last 10 seconds.
class Logger {

    private HashMap<String, Integer> map;

    public Logger() {
        this.map = new HashMap<>();

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean isPresent = map.containsKey(message);

        if (!isPresent) {
            map.put(message, timestamp);
            return true;
        } else {
            int current = map.get(message);
            int diff = timestamp - current;
            if (diff < 10) {
                return false;
            } else {
                map.put(message, timestamp);
                return true;
            }
        }

    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */