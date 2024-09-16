// Time: O(1) | Space: O(No of incoming messages)

class Logger {
    Map<String, Integer> queue;
    public Logger() {
        queue = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean toUpdate = true;
        // whenever a message with timestamp arrives, we check if the message already is there in the queue
        // and not expired yet
        // the expiration time is set as 10,
        // only if the expiration time is finished
        // we will update the queue on the same key with new timestamp
        if(queue.containsKey(message) && (timestamp - queue.get(message)) < 10) toUpdate = false;
        if(toUpdate) queue.put(message,timestamp);
        return toUpdate;
    }
}
